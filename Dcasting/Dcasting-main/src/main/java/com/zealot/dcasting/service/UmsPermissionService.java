package com.zealot.dcasting.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.model.UmsPermission;

/**
 * 使用者權限管理Service
 * Created by LeoLiu on 2020/6/8.
 */
public interface UmsPermissionService {
    /**
     * 添加權限
     */
    int create(UmsPermission permission);

    /**
     * 修改權限
     */
    int update(Long id,UmsPermission permission);

    /**
     * 批量刪除權限
     */
    @Transactional
    int delete(Long id);

    /**
     * 獲取權限詳情
     */
    UmsPermission getItem(Long id);
    
    /**
     * 分頁查詢權限
     */
    List<UmsPermission> list(Long categoryId, String nameKeyword, String valueKeyword, Integer pageSize, Integer pageNum);
    
    /**
     * 獲取所有權限
     */
    List<UmsPermission> listAll();
    
    /**
     * 獲取使用者所有權限（包括角色權限和+-權限）
     */
    List<UmsPermission> getPermissionListByUserId(Long userId);
    
    /**
     * 獲取指定角色權限
     */
    List<UmsPermission> getPermissionListByRoleId(Long roleId);
    
    /**
     * 修改使用者的+-權限
     */
    @Transactional
    int allocPermissionToUser(Long userId, List<Long> permissionIds);
    
    /**
     * 給角色分配權限
     */
    @Transactional
    int allocPermissionToRole(Long roleId, List<Long> permissionIds);
}
