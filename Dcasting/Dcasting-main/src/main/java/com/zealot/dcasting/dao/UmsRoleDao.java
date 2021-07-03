package com.zealot.dcasting.dao;

import org.apache.ibatis.annotations.Param;

import com.zealot.dcasting.model.UmsPermission;

import java.util.Date;
import java.util.List;

/**
 * 自定義角色管理Dao
 * Created by LeoLiu on 2020/6/7.
 */
public interface UmsRoleDao {
    /**
     * 根據角色獲取權限
     */
    List<UmsPermission> getPermissionListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根據指定的role Id把role的flag變成0, 假刪除
     */
    int deleteRoleByIds(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") Long id);
}
