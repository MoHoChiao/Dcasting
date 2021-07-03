package com.zealot.dcasting.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zealot.dcasting.model.ProjectDetails;

/**
 * 自定義專案明細管理Dao
 * Created by LeoLiu on 2021/6/9.
 */
public interface ProjectDetailsDao {
    /**
     * 根據指定的Id把ProjectDetail的flag變成0, 假刪除
     */
    int deleteDetailsById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") Long id);
    
    /**
     * 根據指定的projectId把ProjectDetail的flag變成0, 假刪除
     */
    int deleteDetailsByProjectId(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("projectId") String projectId);
    /**
     * 批量插入專案
     */
    int insertList(@Param("list")List<ProjectDetails> list);
}
