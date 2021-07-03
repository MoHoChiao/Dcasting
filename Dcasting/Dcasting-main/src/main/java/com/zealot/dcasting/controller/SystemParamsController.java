package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.model.SystemParams;
import com.zealot.dcasting.service.SystemParamsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 系統參數管理
 * Created by LeoLiu on 2021/5/8.
 */
@Controller
@Api(tags = "SystemParamsController", description = "系統參數管理")
@RequestMapping("/params")
public class SystemParamsController {
    @Autowired
    private SystemParamsService paramsService;
    
    @ApiOperation("查詢所有系統參數")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SystemParams>> listAll(@RequestParam(value = "type", required = false) String type) {
        List<SystemParams> paramsList = paramsService.listAll(type);
        return CommonResult.success(paramsList);
    }
    
    @ApiOperation("根據關鍵字-分頁獲取系統參數")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SystemParams>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   	@RequestParam(value = "orderByClause", required = false) String orderByClause,
                                                   	@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   	@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                   	@RequestParam(value = "type", required = false) String type) {
        List<SystemParams> paramsList = paramsService.list(keyword, orderByClause, pageSize, pageNum, type);
        return CommonResult.success(CommonPage.restPage(paramsList));
    }
    
    @ApiOperation("添加系統參數")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SystemParams params) {
        int count = paramsService.create(params);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.SystemParams.AddParamsFail");
        }
    }

    @ApiOperation("修改系統參數")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody SystemParams params) {
        int count = paramsService.update(id, params);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Inquiries.EditParamsFail");
        }
    }

    @ApiOperation("根據ID刪除系統參數")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) Long id) {
    	Date updatetime = new Date();
        int count = paramsService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Inquiries.DeleteParamsFail");
    }
}
