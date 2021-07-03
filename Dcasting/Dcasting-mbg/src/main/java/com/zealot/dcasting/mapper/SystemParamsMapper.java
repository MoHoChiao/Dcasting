package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.SystemParams;
import com.zealot.dcasting.model.SystemParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParamsMapper {
    long countByExample(SystemParamsExample example);

    int deleteByExample(SystemParamsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemParams record);

    int insertSelective(SystemParams record);

    List<SystemParams> selectByExample(SystemParamsExample example);

    SystemParams selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemParams record, @Param("example") SystemParamsExample example);

    int updateByExample(@Param("record") SystemParams record, @Param("example") SystemParamsExample example);

    int updateByPrimaryKeySelective(SystemParams record);

    int updateByPrimaryKey(SystemParams record);
}