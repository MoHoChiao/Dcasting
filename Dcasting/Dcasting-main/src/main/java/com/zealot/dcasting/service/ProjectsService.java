package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zealot.dcasting.dto.ProjectsQueryParam;
import com.zealot.dcasting.model.Projects;

/**
 * 專案管理Service
 * Created by LeoLiu on 2021/6/9.
 */
public interface ProjectsService {
    /**
     * 獲取所有專案
     */
    List<Projects> listAll();
    
    /**
     * 根據關鍵字分頁查詢專案
     */
    List<Projects> list(ProjectsQueryParam queryParam);
    
    /**
     * 創建專案
     */
    int create(Projects projects);
    
    /**
     * 創建專案且傳回訂單ID
     */
    String createAndReturnId(Projects projects);

    /**
     * 修改專案
     */
    int update(String id, Projects projects);

    /**
     * 根據ID改變專案狀態
     */
    int updateProgress(Long userid, String progress, String id);
    
    /**
     * 根據ID改變專案狀態
     */
    int updateStatus(Long userid, String id);
    
    /**
     * 刪除專案
     */
    @Transactional
    int delete(Date update_datetime, Long update_user_id, String id);
}
