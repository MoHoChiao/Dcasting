package com.zealot.dcasting.service;

import java.util.List;

import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsUser;

/**
 * 使用者緩存操作類
 * Created by LeoLiu on 2020/6/8.
 */
public interface UmsUserCacheService {
    /**
     * 刪除使用者緩存
     */
    void delUser(Long userId);
    
    /**
     * 刪除使用者緩存
     */
    void delUser(String username);

    /**
     * 刪除使用者權限列表緩存
     */
    void delPermissionList(Long userId);

    /**
     * 當角色相關權限信息改變時刪除相關使用者緩存
     */
    void delPermissionListByRole(Long roleId);

    /**
     * 當角色相關權限信息改變時刪除相關使用者緩存
     */
    void delPermissionListByRoleIds(List<Long> roleIds);

    /**
     * 當權限信息改變時，刪除權限項目使用者緩存
     */
    void delPermissionListByPermission(Long permissionId);

    /**
     * 獲取緩存使用者信息
     */
    UmsUser getUser(String username);

    /**
     * 設置緩存使用者信息
     */
    void setUser(UmsUser user);

    /**
     * 獲取緩存使用者權限列表
     */
    List<UmsPermission> getPermissionList(Long userId);

    /**
     * 設置使用者權限列表
     */
    void setPermissionList(Long userId, List<UmsPermission> permissionList);
    
    /**
     * 獲取緩存使用者權限列表
     */
    void setExpireByUser(Long expireTime, String username);
}
