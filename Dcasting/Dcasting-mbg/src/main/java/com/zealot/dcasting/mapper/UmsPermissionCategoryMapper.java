package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.UmsPermissionCategory;
import com.zealot.dcasting.model.UmsPermissionCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsPermissionCategoryMapper {
    long countByExample(UmsPermissionCategoryExample example);

    int deleteByExample(UmsPermissionCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsPermissionCategory record);

    int insertSelective(UmsPermissionCategory record);

    List<UmsPermissionCategory> selectByExample(UmsPermissionCategoryExample example);

    UmsPermissionCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsPermissionCategory record, @Param("example") UmsPermissionCategoryExample example);

    int updateByExample(@Param("record") UmsPermissionCategory record, @Param("example") UmsPermissionCategoryExample example);

    int updateByPrimaryKeySelective(UmsPermissionCategory record);

    int updateByPrimaryKey(UmsPermissionCategory record);
}