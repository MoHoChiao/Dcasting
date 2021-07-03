package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.model.UmsGroup;

/**
 * 群組管理Service
 * Created by LeoLiu on 2021/5/8.
 */
public interface UmsGroupService {

    /**
     * 獲取所有群組
     */
    List<UmsGroup> listAll();

    /**
     * 根據關鍵字分頁查詢群組
     */
    List<UmsGroup> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum);
    
    /**
     * 創建群組
     */
    int create(UmsGroup umsGroup);

    /**
     * 修改群組
     */
    int update(Long id, UmsGroup umsGroup);

    /**
     * 刪除群組
     */
    @Transactional
    int delete(Date update_datetime, Long update_user_id, Long id);
}
