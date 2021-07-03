package com.zealot.dcasting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * 自定義群組管理Dao
 * Created by LeoLiu on 2021/5/7.
 */
public interface UmsGroupDao {
    /**
     * 根據指定的group Id把group的flag變成0, 假刪除
     */
    int deleteGroupById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") Long id);
}
