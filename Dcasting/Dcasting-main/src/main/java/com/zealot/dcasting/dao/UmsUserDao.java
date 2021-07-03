package com.zealot.dcasting.dao;

import com.zealot.dcasting.dto.UmsUserExampleRet;
import com.zealot.dcasting.dto.UmsUserRet;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 自定義使用者管理Dao
 * Created by LeoLiu on 2021/5/7.
 */
public interface UmsUserDao {
	/**
     * 根據ID獲取使用者及所屬群組名稱
     */
	UmsUserRet selectByPrimaryKey(Long id);
    /**
     * 獲取使用者及所屬群組名稱的列表
     */
    List<UmsUserRet> leftJoinSelectByExample(UmsUserExampleRet example);
    /**
     * 根據指定的groupId把所有user的flag變成0, 假性刪除
     */
    int deleteByGroupId(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("groupId") Long groupId);
    /**
     * 根據指定的Id把user的flag變成0, 假性刪除
     */
    int deleteById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") Long id);
}
