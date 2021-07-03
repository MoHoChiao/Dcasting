package com.zealot.dcasting.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.dto.QuotationsParamRet;
import com.zealot.dcasting.dto.QuotationsQueryParam;
import com.zealot.dcasting.model.Quotations;

/**
 * 報價單管理Service
 * Created by LeoLiu on 2021/5/8.
 */
public interface QuotationsService {

    /**
     * 獲取所有報價單
     */
    List<Quotations> listAll();

    /**
     * 查詢所有報價單上的下拉選單參數
     */
    QuotationsParamRet listAllQuotationsParams();
    
    /**
     * 根據關鍵字分頁查詢報價單
     */
    List<Quotations> list(QuotationsQueryParam queryParam);
    
    /**
     * 創建報價單
     */
    int create(Quotations quotations);

    /**
     * 修改報價單
     */
    int update(String id, Quotations quotations);

    /**
     * 根據ID改變報價單狀態
     */
    @Transactional
    int updateStatus(Long userid, String status, String id);
    
    /**
     * 刪除報價單
     */
    @Transactional
    int delete(String id);
}
