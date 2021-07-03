package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.QuotationDetailsParamRet;
import com.zealot.dcasting.dto.QuotationsParamRet;
import com.zealot.dcasting.dto.QuotationsQueryParam;
import com.zealot.dcasting.model.QuotationDetails;
import com.zealot.dcasting.model.Quotations;
import com.zealot.dcasting.service.QuotationDetailsService;
import com.zealot.dcasting.service.QuotationsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 報價單管理
 * Created by LeoLiu on 2021/5/27.
 */
@Controller
@Api(tags = "QuotationsController", description = "報價單管理")
@RequestMapping("/quotations")
public class QuotationsController {
    @Autowired
    private QuotationsService quotationsService;
    @Autowired
    private QuotationDetailsService quotationDetailsService;
    
    @ApiOperation("查詢所有報價單")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Quotations>> listAll() {
        List<Quotations> quotationsList = quotationsService.listAll();
        return CommonResult.success(quotationsList);
    }

    @ApiOperation("查詢所有報價單上的下拉選單參數")
    @RequestMapping(value = "/listAllQuotationsParams", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<QuotationsParamRet> listAllQuotationsParams() {
    	QuotationsParamRet paramsList = quotationsService.listAllQuotationsParams();
        return CommonResult.success(paramsList);
    }
    
    @ApiOperation("根據關鍵字-分頁獲取報價單列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<Quotations>> list(@RequestBody QuotationsQueryParam queryParam) {
        List<Quotations> quotationsList = quotationsService.list(queryParam);
        return CommonResult.success(CommonPage.restPage(quotationsList));
    }
    
    @ApiOperation("添加報價單")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createQuotations(@RequestBody Quotations quotations) {
        int count = quotationsService.create(quotations);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Quotations.AddQuotationsFail");
        }
    }

    @ApiOperation("修改報價單")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateQuotations(@PathVariable String id,
                               @RequestBody Quotations quotations) {
        int count = quotationsService.update(id, quotations);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Quotations.EditQuotationsFail");
        }
    }

    @ApiOperation("根據ID改變報價單狀態")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateQuotationsStatus(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id,
           							@RequestParam(value = "status", required = true) String status) {
        int count = quotationsService.updateStatus(userid, status, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Quotations.UpdateQuotationsStatusFail");
    }
    
    @ApiOperation("根據ID刪除報價單")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteQuotations(@RequestParam(value = "id", required = true) String id) {
        int count = quotationsService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Quotations.DeleteQuotationsFail");
    }
    
    @ApiOperation("查詢所有報價單明細上的下拉選單參數")
    @RequestMapping(value = "/listAllDetailsParams", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<QuotationDetailsParamRet> listAllDetailsParams() {
    	QuotationDetailsParamRet paramsList = quotationDetailsService.listAllQuotationDetailsParams();
        return CommonResult.success(paramsList);
    }
    
    @ApiOperation("查詢所有報價單明細")
    @RequestMapping(value = "/listAllDetails", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<QuotationDetails>> listAllDetails() {
        List<QuotationDetails> quotationDetailsList = quotationDetailsService.listAll();
        return CommonResult.success(quotationDetailsList);
    }

    @ApiOperation("根據報價單獲取報價單明細列表")
    @RequestMapping(value = "/listDetails", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<QuotationDetails>> listDetails(@RequestParam(value = "quotationId", required = true) String quotationId,
    												@RequestParam(value = "orderByClause", required = true) String orderByClause) {
        List<QuotationDetails> quotationDetailsList = quotationDetailsService.list(quotationId, orderByClause);
        return CommonResult.success(quotationDetailsList);
    }
    
    @ApiOperation("添加報價單明細")
    @RequestMapping(value = "/createDetails", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDetails(@RequestBody QuotationDetails umsDetails) {
        int count = quotationDetailsService.create(umsDetails);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.QuotationDetails.AddDetailsFail");
        }
    }

    @ApiOperation("修改報價單明細")
    @RequestMapping(value = "/updateDetails/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDetails(@PathVariable Long id,
                               @RequestBody QuotationDetails umsDetails) {
        int count = quotationDetailsService.update(id, umsDetails);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.QuotationDetails.EditDetailsFail");
        }
    }

    @ApiOperation("根據ID刪除報價單明細")
    @RequestMapping(value = "/deleteDetails", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteDetails(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) Long id) {
    	Date updatetime = new Date();
        int count = quotationDetailsService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.QuotationDetails.DeleteDetailsFail");
    }
}
