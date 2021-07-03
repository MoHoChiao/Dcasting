package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.DashboardPanelGroupRet;
import com.zealot.dcasting.dto.DashboardPieRet;
import com.zealot.dcasting.service.DashboardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 首頁管理
 * Created by LeoLiu on 2021/6/17.
 */
@Controller
@Api(tags = "DashboardController", description = "首頁管理")
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;
    
    @ApiOperation("查詢PanelGroup")
    @RequestMapping(value = "/getPanelGroup", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DashboardPanelGroupRet> getPanelGroup(@RequestParam(value = "usertype", required = true) String usertype,
    												@RequestParam(value = "userid", required = false) Long userid,
    												@RequestParam(value = "groupid", required = false) Long groupid) {
    	DashboardPanelGroupRet panelGroupValues = dashboardService.getPanelGroup(usertype, userid, groupid);
        return CommonResult.success(panelGroupValues);
    }
    
    @ApiOperation("查詢詢價單PieChart")
    @RequestMapping(value = "/getInquiriesPie", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DashboardPieRet> getInquiriesPie(@RequestParam(value = "usertype", required = true) String usertype,
    												@RequestParam(value = "userid", required = false) Long userid,
    												@RequestParam(value = "groupid", required = false) Long groupid) {
    	DashboardPieRet pieValues = dashboardService.getInquiriesPie(usertype, userid, groupid);
        return CommonResult.success(pieValues);
    }
    
    @ApiOperation("查詢報價單PieChart")
    @RequestMapping(value = "/getQuotationsPie", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DashboardPieRet> getQuotationsPie(@RequestParam(value = "usertype", required = true) String usertype,
    												@RequestParam(value = "userid", required = false) Long userid,
    												@RequestParam(value = "groupid", required = false) Long groupid) {
    	DashboardPieRet pieValues = dashboardService.getQuotationsPie(usertype, userid, groupid);
        return CommonResult.success(pieValues);
    }
    
    @ApiOperation("查詢銷售訂單PieChart")
    @RequestMapping(value = "/getOrdersPie", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DashboardPieRet> getOrdersPie(@RequestParam(value = "usertype", required = true) String usertype,
    												@RequestParam(value = "userid", required = false) Long userid,
    												@RequestParam(value = "groupid", required = false) Long groupid) {
    	DashboardPieRet pieValues = dashboardService.getOrdersPie(usertype, userid, groupid);
        return CommonResult.success(pieValues);
    }
    
    @ApiOperation("查詢專案PieChart")
    @RequestMapping(value = "/getProjectsPie", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DashboardPieRet> getProjectsPie(@RequestParam(value = "usertype", required = true) String usertype,
    												@RequestParam(value = "userid", required = false) Long userid,
    												@RequestParam(value = "groupid", required = false) Long groupid) {
    	DashboardPieRet pieValues = dashboardService.getProjectsPie(usertype, userid, groupid);
        return CommonResult.success(pieValues);
    }
}
