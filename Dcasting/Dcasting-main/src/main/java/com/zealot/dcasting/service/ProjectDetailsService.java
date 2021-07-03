package com.zealot.dcasting.service;

import java.util.Date;
import java.util.List;
import com.zealot.dcasting.model.ProjectDetails;

/**
 * 專案明細Service
 * Created by LeoLiu on 2021/6/9.
 */
public interface ProjectDetailsService {

    /**
     * 獲取所有專案明細
     */
    List<ProjectDetails> listAll();

    /**
     * 根據專案查詢專案明細
     */
    List<ProjectDetails> list(String projectId, String orderByClause);
    
    /**
     * 創建專案明細
     */
    int create(ProjectDetails details);

    /**
     * 修改專案明細
     */
    int update(Long id, ProjectDetails details);

    /**
     * 刪除專案明細
     */
    int delete(Date update_datetime, Long update_user_id, Long id);
    
    /**
     * 根據ID改變專案進度
     */
    int updateProgress(Long userid, String progress, Long id);
}
