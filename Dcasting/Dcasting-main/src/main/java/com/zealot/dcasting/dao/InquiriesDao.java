package com.zealot.dcasting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * 自定義詢價單管理Dao
 * Created by LeoLiu on 2021/5/7.
 */
public interface InquiriesDao {
	/**
     * 取得詢價單最新的ID編號
     */
	String getLastId(String preString);
	
    /**
     * 根據指定的詢價單 Id把詢價單的flag變成0, 假刪除
     */
    int deleteInquiriesById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") String id);
    
    /**
     * 取得詢價單最新的ID編號
     */
	int setAttachFilePath(@Param("inquiryId") String inquiryId, @Param("filePath") String filePath);
}
