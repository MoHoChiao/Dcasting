package com.zealot.dcasting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * 自定義報價單管理Dao
 * Created by LeoLiu on 2021/5/27.
 */
public interface QuotationsDao {
	/**
     * 取得報價單最新的ID編號
     */
	String getLastId(String preString);
    /**
     * 根據指定的報價單 Id把報價單的flag變成0, 假刪除
     */
    int deleteQuotationsById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") String id);
}
