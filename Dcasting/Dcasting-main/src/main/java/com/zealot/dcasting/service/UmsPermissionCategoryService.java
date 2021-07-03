package com.zealot.dcasting.service;

import java.util.List;

import com.zealot.dcasting.model.UmsPermissionCategory;

/**
 * 權限分類管理Service
 * Created by LeoLiu on 2020/6/8.
 */
public interface UmsPermissionCategoryService {

    /**
     * 獲取所有權限分類
     */
    List<UmsPermissionCategory> listAll();

    /**
     * 創建權限分類
     */
    int create(UmsPermissionCategory umsPermissionCategory);

    /**
     * 修改權限分類
     */
    int update(Long id, UmsPermissionCategory umsPermissionCategory);

    /**
     * 刪除權限分類
     */
    int delete(Long id);
}
