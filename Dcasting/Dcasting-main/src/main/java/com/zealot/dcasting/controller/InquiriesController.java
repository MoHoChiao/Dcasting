package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.InquiriesQueryParam;
import com.zealot.dcasting.dto.InquiriesParamRet;
import com.zealot.dcasting.model.Inquiries;
import com.zealot.dcasting.service.InquiriesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 詢價單管理
 * Created by LeoLiu on 2021/5/8.
 */
@Controller
@Api(tags = "InquiriesController", description = "詢價單管理")
@RequestMapping("/inquiries")
public class InquiriesController {
    @Autowired
    private InquiriesService inquiriesService;
    
    private static final Logger logger = LoggerFactory.getLogger(InquiriesController.class);
    
    @ApiOperation("根據ID查詢詢價單")
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Inquiries> getById(@RequestParam(value = "inquiryId", required = true) String inquiryId) {
        return CommonResult.success(inquiriesService.getById(inquiryId));
    }
    
    @ApiOperation("查詢所有詢價單")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Inquiries>> listAll() {
        List<Inquiries> inquiriesList = inquiriesService.listAll();
        return CommonResult.success(inquiriesList);
    }

    @ApiOperation("查詢所有詢價單上的下拉選單參數")
    @RequestMapping(value = "/listAllInquiriesParams", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<InquiriesParamRet> listAllInquiriesParams() {
    	InquiriesParamRet paramsList = inquiriesService.listAllInquiriesParams();
        return CommonResult.success(paramsList);
    }
    
    @ApiOperation("根據關鍵字-分頁獲取詢價單列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<Inquiries>> list(@RequestBody InquiriesQueryParam queryParam) {
        List<Inquiries> inquiriesList = inquiriesService.list(queryParam);
        return CommonResult.success(CommonPage.restPage(inquiriesList));
    }
    
    @ApiOperation("添加詢價單")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createInquiries(@RequestBody Inquiries inquiries) {
        int count = inquiriesService.create(inquiries);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Inquiries.AddInquiriesFail");
        }
    }

    @ApiOperation("修改詢價單")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateInquiries(@PathVariable String id,
                               @RequestBody Inquiries inquiries) {
        int count = inquiriesService.update(id, inquiries);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Inquiries.EditInquiriesFail");
        }
    }

    @ApiOperation("根據ID改變詢價單狀態")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateInquiriesStatus(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id,
           							@RequestParam(value = "status", required = true) String status) {
        int count = inquiriesService.updateStatus(userid, status, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Inquiries.UpdateInquiriesStatusFail");
    }
    
    @ApiOperation("根據ID刪除詢價單")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteInquiries(@RequestParam(value = "id", required = true) String id) {
    	Date updatetime = new Date();
        int count = inquiriesService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Inquiries.DeleteInquiriesFail");
    }
    
    @ApiOperation("上傳檔案")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam(value = "inquiryId", required = true) String inquiryId,
    							@RequestParam(value = "uploadFile", required = true) MultipartFile uploadFile,
    							HttpServletRequest req) {
    	int count = inquiriesService.upload(inquiryId, uploadFile, req);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Inquiries.UploadFileFail");
        }
    }
    
    @ApiOperation("下載檔案")
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Resource> download(@RequestParam(value = "inquiryId", required = true) String inquiryId, HttpServletRequest request) {
    	Resource resource = inquiriesService.download(inquiryId);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        String filename = "test11111";
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .body(resource);
    }
}
