package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.dto.OrdersQueryParam;
import com.zealot.dcasting.model.SaleOrders;

/**
 * 銷售訂單管理Service
 * Created by LeoLiu on 2021/6/6.
 */
public interface OrdersService {
    /**
     * 獲取所有銷售訂單
     */
    List<SaleOrders> listAll();
    
    /**
     * 根據關鍵字分頁查詢銷售訂單
     */
    List<SaleOrders> list(OrdersQueryParam queryParam);
    
    /**
     * 創建銷售訂單
     */
    int create(SaleOrders orders);
    
    /**
     * 創建銷售訂單且傳回訂單ID
     */
    String createAndReturnId(SaleOrders orders);

    /**
     * 修改銷售訂單
     */
    int update(String id, SaleOrders orders);

    /**
     * 根據ID改變銷售訂單狀態
     */
    int updateStatus(Long userid, String status, String id);
    
    /**
     * 刪除銷售訂單
     */
    @Transactional
    int delete(Date update_datetime, Long update_user_id, String id);
}
