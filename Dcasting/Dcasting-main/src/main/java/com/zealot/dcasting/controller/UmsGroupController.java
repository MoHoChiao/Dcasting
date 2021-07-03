package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.model.UmsGroup;
import com.zealot.dcasting.service.UmsGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 使用者群組管理
 * Created by LeoLiu on 2021/5/8.
 */
@Controller
@Api(tags = "UmsGroupController", description = "使用者群組管理")
@RequestMapping("/group")
public class UmsGroupController {
    @Autowired
    private UmsGroupService groupService;
    
    @ApiOperation("查詢所有群組")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsGroup>> listAll() {
        List<UmsGroup> groupList = groupService.listAll();
        return CommonResult.success(groupList);
    }

    @ApiOperation("根據關鍵字-分頁獲取群組列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsGroup>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   	@RequestParam(value = "orderByClause", required = false) String orderByClause,
                                                   	@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   	@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsGroup> groupList = groupService.list(keyword, orderByClause, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(groupList));
    }
    
    @ApiOperation("添加群組")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createGroup(@RequestBody UmsGroup umsGroup) {
        int count = groupService.create(umsGroup);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Group.AddGroupFail");
        }
    }

    @ApiOperation("修改群組")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateGroup(@PathVariable Long id,
                               @RequestBody UmsGroup umsGroup) {
        int count = groupService.update(id, umsGroup);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Group.EditGroupFail");
        }
    }

    @ApiOperation("根據ID刪除群組")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteGroup(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) Long id) {
    	Date updatetime = new Date();
        int count = groupService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Group.DeleteGroupFail");
    }
}
