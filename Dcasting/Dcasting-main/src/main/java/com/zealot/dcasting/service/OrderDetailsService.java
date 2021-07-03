package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.model.SaleOrderDetails;

/**
 * 銷售訂單明細Service
 * Created by LeoLiu on 2021/6/6.
 */
public interface OrderDetailsService {

    /**
     * 獲取所有銷售訂單明細
     */
    List<SaleOrderDetails> listAll();

    /**
     * 根據銷售訂單查詢銷售訂單明細
     */
    List<SaleOrderDetails> list(String orderId, String orderByClause);
    
    /**
     * 創建銷售訂單明細
     */
    int create(SaleOrderDetails details);

    /**
     * 修改銷售訂單明細
     */
    int update(Long id, SaleOrderDetails details);

    /**
     * 刪除銷售訂單明細
     */
    int delete(Date update_datetime, Long update_user_id, Long id);
}
