package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.UserAndGroupParamRet;
import com.zealot.dcasting.service.CommonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 無權限的共用方法
 * Created by LeoLiu on 2021/6/9.
 */
@Controller
@Api(tags = "CommonController", description = "無權限的共用方法")
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;
    
    @ApiOperation("根據inquiriesUserId及supplierUserId, 一次取得他們的username及groupname")
    @RequestMapping(value = "/getUsernameAndGroupnameObj", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UserAndGroupParamRet> getUsernameAndGroupnameObj(@RequestParam(value = "inquiriesUserId", required = false) Long inquiriesUserId,
    														@RequestParam(value = "supplierUserId", required = false) Long supplierUserId) {
    	UserAndGroupParamRet ret = commonService.getUsernameAndGroupnameObj(inquiriesUserId, supplierUserId);
        return CommonResult.success(ret);
    }
}
