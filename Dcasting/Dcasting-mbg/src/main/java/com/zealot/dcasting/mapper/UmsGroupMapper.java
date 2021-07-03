package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.UmsGroup;
import com.zealot.dcasting.model.UmsGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsGroupMapper {
    long countByExample(UmsGroupExample example);

    int deleteByExample(UmsGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsGroup record);

    int insertSelective(UmsGroup record);

    List<UmsGroup> selectByExample(UmsGroupExample example);

    UmsGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsGroup record, @Param("example") UmsGroupExample example);

    int updateByExample(@Param("record") UmsGroup record, @Param("example") UmsGroupExample example);

    int updateByPrimaryKeySelective(UmsGroup record);

    int updateByPrimaryKey(UmsGroup record);
}