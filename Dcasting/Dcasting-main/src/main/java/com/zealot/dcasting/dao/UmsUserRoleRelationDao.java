package com.zealot.dcasting.dao;

import org.apache.ibatis.annotations.Param;

import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsRole;
import com.zealot.dcasting.model.UmsUserRoleRelation;

import java.util.List;

/**
 * 自定義使用者與角色管理Dao
 * Created by LeoLiu on 2020/6/7.
 */
public interface UmsUserRoleRelationDao {
    /**
     * 批量插入使用者角色關係
     */
    int insertList(@Param("list") List<UmsUserRoleRelation> userRoleRelationList);

    /**
     * 獲取使用者所有角色
     */
    List<UmsRole> getRoleList(@Param("userId") Long userId);

    /**
     * 獲取使用者所有角色權限
     */
    List<UmsPermission> getRolePermissionList(@Param("userId") Long userId);

    /**
     * 獲取使用者所有權限(包括+-權限)
     */
    List<UmsPermission> getPermissionList(@Param("userId") Long userId);

    /**
     * 獲取權限相關使用者ID列表
     */
    List<Long> getUserIdList(@Param("permissionId") Long permissionId);
}
