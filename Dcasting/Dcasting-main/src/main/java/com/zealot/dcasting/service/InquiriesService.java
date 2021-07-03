package com.zealot.dcasting.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zealot.dcasting.dto.InquiriesQueryParam;
import com.zealot.dcasting.dto.InquiriesParamRet;
import com.zealot.dcasting.model.Inquiries;

/**
 * 詢價單管理Service
 * Created by LeoLiu on 2021/5/8.
 */
public interface InquiriesService {
	/**
     * 根據ID查詢詢價單
     */
    Inquiries getById(String inquiryId);

    /**
     * 獲取所有詢價單
     */
    List<Inquiries> listAll();

    /**
     * 查詢所有詢價單上的下拉選單參數
     */
    InquiriesParamRet listAllInquiriesParams();
    
    /**
     * 根據關鍵字分頁查詢詢價單
     */
    List<Inquiries> list(InquiriesQueryParam queryParam);
    
    /**
     * 創建詢價單
     */
    @Transactional
    int create(Inquiries inquiries);

    /**
     * 修改詢價單
     */
    @Transactional
    int update(String id, Inquiries inquiries);

    /**
     * 根據ID改變詢價單狀態
     */
    @Transactional
    int updateStatus(Long userid, String status, String id);
    
    /**
     * 刪除詢價單
     */
    @Transactional
    int delete(String id);
    
    /**
     * 上傳檔案
     */
    int upload(String inqueryId, MultipartFile uploadFile, HttpServletRequest req);
    
    /**
     * 上傳檔案
     */
    Resource download(String inqueryId);
}
