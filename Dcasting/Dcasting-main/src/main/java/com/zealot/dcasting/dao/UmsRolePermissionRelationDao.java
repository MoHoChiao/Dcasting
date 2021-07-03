package com.zealot.dcasting.dao;

import org.apache.ibatis.annotations.Param;

import com.zealot.dcasting.model.UmsRolePermissionRelation;

import java.util.List;

/**
 * 自定義角色權限關係管理Dao
 * Created by LeoLiu on 2020/6/7.
 */
public interface UmsRolePermissionRelationDao {
    /**
     * 批量插入角色和權限關係
     */
    int insertList(@Param("list")List<UmsRolePermissionRelation> list);
}
