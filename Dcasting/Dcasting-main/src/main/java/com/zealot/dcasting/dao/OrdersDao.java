package com.zealot.dcasting.dao;

import java.util.Date;
import org.apache.ibatis.annotations.Param;

/**
 * 自定義銷售訂單管理Dao
 * Created by LeoLiu on 2021/6/6.
 */
public interface OrdersDao {
	/**
     * 取得銷售訂單最新的ID編號
     */
	String getLastId(String preString);
    /**
     * 根據指定的銷售訂單 Id把銷售訂單的flag變成0, 假刪除
     */
    int deleteOrdersById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") String id);
}
