package com.zealot.dcasting.dao;

import org.apache.ibatis.annotations.Param;

import com.zealot.dcasting.model.UmsUserPermissionRelation;

import java.util.List;

/**
 * 自定義使用者權限關係管理Dao
 * Created by LeoLiu on 2020/6/7.
 */
public interface UmsUserPermissionRelationDao {
    /**
     * 批量插入使用者和權限關係
     */
    int insertList(@Param("list") List<UmsUserPermissionRelation> list);
    
    /**
     * 獲取權限相關使用者ID列表
     */
    List<Long> getUserIdList(@Param("permissionId") Long permissionId);
}
