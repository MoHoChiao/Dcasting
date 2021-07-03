package com.zealot.dcasting.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zealot.dcasting.model.SaleOrderDetails;

/**
 * 自定義銷售訂單明細管理Dao
 * Created by LeoLiu on 2021/6/6.
 */
public interface OrderDetailsDao {
    /**
     * 根據指定的Id把OrderDetail的flag變成0, 假刪除
     */
    int deleteDetailsById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") Long id);
    
    /**
     * 根據指定的orderId把OrderDetail的flag變成0, 假刪除
     */
    int deleteDetailsByOrderId(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("orderId") String orderId);
    /**
     * 批量插入銷售訂單
     */
    int insertList(@Param("list")List<SaleOrderDetails> list);
}
