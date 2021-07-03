package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.dto.QuotationDetailsParamRet;
import com.zealot.dcasting.model.QuotationDetails;

/**
 * 報價單明細Service
 * Created by LeoLiu on 2021/6/4.
 */
public interface QuotationDetailsService {

    /**
     * 獲取所有報價單明細
     */
    List<QuotationDetails> listAll();

    /**
     * 根據報價單查詢報價單明細
     */
    List<QuotationDetails> list(String quotationId, String orderByClause);
    
    /**
     * 查詢報價單明細的下拉選單
     */
    QuotationDetailsParamRet listAllQuotationDetailsParams();
    
    /**
     * 創建報價單明細
     */
    @Transactional
    int create(QuotationDetails details);

    /**
     * 修改報價單明細
     */
    @Transactional
    int update(Long id, QuotationDetails details);

    /**
     * 刪除報價單明細
     */
    @Transactional
    int delete(Date update_datetime, Long update_user_id, Long id);
}
