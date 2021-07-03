package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.UmsUserPermissionRelation;
import com.zealot.dcasting.model.UmsUserPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserPermissionRelationMapper {
    long countByExample(UmsUserPermissionRelationExample example);

    int deleteByExample(UmsUserPermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsUserPermissionRelation record);

    int insertSelective(UmsUserPermissionRelation record);

    List<UmsUserPermissionRelation> selectByExample(UmsUserPermissionRelationExample example);

    UmsUserPermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsUserPermissionRelation record, @Param("example") UmsUserPermissionRelationExample example);

    int updateByExample(@Param("record") UmsUserPermissionRelation record, @Param("example") UmsUserPermissionRelationExample example);

    int updateByPrimaryKeySelective(UmsUserPermissionRelation record);

    int updateByPrimaryKey(UmsUserPermissionRelation record);
}