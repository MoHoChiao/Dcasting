package com.zealot.dcasting.service;

import com.zealot.dcasting.model.UmsRole;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 角色管理Service
 * Created by LeoLiu on 2020/6/8.
 */
public interface UmsRoleService {
    /**
     * 添加角色
     */
    int create(UmsRole umsRoleParam);

    /**
     * 修改角色信息
     */
    int update(Long id, UmsRole umsRole);

    /**
     * 修改角色狀態
     */
    int updateStatus(UmsRole role);
    
    /**
     * 批量刪除角色
     */
    @Transactional
    int delete(Date update_datetime, Long update_user_id, List<Long> ids);

    /**
     * 獲取使用者的所有角色
     */
    List<UmsRole> getRoleListByUserId(Long userId);

    /**
     * 獲取所有角色列表
     */
    List<UmsRole> listAll();

    /**
     * 分頁獲取角色列表
     */
    List<UmsRole> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum);

    /**
     * 修改使用者角色關係
     */
    @Transactional
    int allocRole(Long userId, List<Long> roleIds);
}
