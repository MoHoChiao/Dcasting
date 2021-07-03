package com.zealot.dcasting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * 自定義專案管理Dao
 * Created by LeoLiu on 2021/6/9.
 */
public interface ProjectsDao {
	/**
     * 取得專案最新的ID編號
     */
	String getLastId(String preString);
    /**
     * 根據指定的專案 Id把專案的flag變成0, 假刪除
     */
    int deleteProjectsById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") String id);
}
