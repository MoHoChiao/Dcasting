package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.ProjectsQueryParam;
import com.zealot.dcasting.model.ProjectDetails;
import com.zealot.dcasting.model.Projects;
import com.zealot.dcasting.service.ProjectDetailsService;
import com.zealot.dcasting.service.ProjectsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 專案管理
 * Created by LeoLiu on 2021/6/9.
 */
@Controller
@Api(tags = "ProjectsController", description = "專案管理")
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;
    @Autowired
    private ProjectDetailsService projectDetailsService;
    
    @ApiOperation("查詢所有專案")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Projects>> listAll() {
        List<Projects> projectsList = projectsService.listAll();
        return CommonResult.success(projectsList);
    }
    
    @ApiOperation("根據關鍵字-分頁獲取專案列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<Projects>> list(@RequestBody ProjectsQueryParam queryParam) {
        List<Projects> projectsList = projectsService.list(queryParam);
        return CommonResult.success(CommonPage.restPage(projectsList));
    }
    
    @ApiOperation("添加專案")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createProjects(@RequestBody Projects projects) {
        int count = projectsService.create(projects);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Projects.AddProjectsFail");
        }
    }

    @ApiOperation("修改專案")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateProjects(@PathVariable String id,
                               @RequestBody Projects projects) {
        int count = projectsService.update(id, projects);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Projects.EditProjectsFail");
        }
    }

    @ApiOperation("根據ID改變專案進度")
    @RequestMapping(value = "/updateProgress", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateProjectsProgress(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id,
           							@RequestParam(value = "progress", required = true) String progress) {
        int count = projectsService.updateProgress(userid, progress, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Projects.UpdateProjectsProgressFail");
    }
    
    @ApiOperation("根據ID改變專案狀態")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateProjectsStatus(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id) {
        int count = projectsService.updateStatus(userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Projects.UpdateProjectsStatusFail");
    }
    
    @ApiOperation("根據ID刪除專案")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteProjects(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id) {
    	Date updatetime = new Date();
        int count = projectsService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Projects.DeleteProjectsFail");
    }
    
    @ApiOperation("查詢所有專案工作項目")
    @RequestMapping(value = "/listAllDetails", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProjectDetails>> listAllDetails() {
        List<ProjectDetails> projectDetailsList = projectDetailsService.listAll();
        return CommonResult.success(projectDetailsList);
    }

    @ApiOperation("根據專案獲取專案工作項目列表")
    @RequestMapping(value = "/listDetails", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProjectDetails>> listDetails(@RequestParam(value = "projectId", required = true) String projectId,
    												@RequestParam(value = "orderByClause", required = true) String orderByClause) {
        List<ProjectDetails> projectDetailsList = projectDetailsService.list(projectId, orderByClause);
        return CommonResult.success(projectDetailsList);
    }
    
    @ApiOperation("添加專案工作項目")
    @RequestMapping(value = "/createDetails", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDetails(@RequestBody ProjectDetails details) {
        int count = projectDetailsService.create(details);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.ProjectDetails.AddDetailsFail");
        }
    }

    @ApiOperation("修改專案工作項目")
    @RequestMapping(value = "/updateDetails/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDetails(@PathVariable Long id,
                               @RequestBody ProjectDetails umsDetails) {
        int count = projectDetailsService.update(id, umsDetails);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.ProjectDetails.EditDetailsFail");
        }
    }

    @ApiOperation("根據ID刪除專案工作項目")
    @RequestMapping(value = "/deleteDetails", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteDetails(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) Long id) {
    	Date updatetime = new Date();
        int count = projectDetailsService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.ProjectDetails.DeleteDetailsFail");
    }
    
    @ApiOperation("根據ID改變專案工作項目進度")
    @RequestMapping(value = "/updateDetailsProgress", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDetailsProgress(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) Long id,
           							@RequestParam(value = "progress", required = true) String progress) {
        int count = projectDetailsService.updateProgress(userid, progress, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Projects.UpdateDetailsProgressFail");
    }
}
