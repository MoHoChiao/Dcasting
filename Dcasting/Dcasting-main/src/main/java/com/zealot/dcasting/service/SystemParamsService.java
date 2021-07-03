package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;

import com.zealot.dcasting.model.SystemParams;

/**
 * 系統參數管理Service
 * Created by LeoLiu on 2021/5/8.
 */
public interface SystemParamsService {

    /**
     * 根據Type獲取所有系統參數
     */
    List<SystemParams> listAll(String type);

    /**
     * 根據關鍵字分頁查詢指定Type系統參數
     */
    List<SystemParams> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum, String type);
    
    /**
     * 創建Inquiries系統參數
     */
    int create(SystemParams systemParams);

    /**
     * 修改Inquiries系統參數
     */
    int update(Long id, SystemParams systemParams);

    /**
     * 刪除Inquiries系統參數
     */
    int delete(Date update_datetime, Long update_user_id, Long id);
}
