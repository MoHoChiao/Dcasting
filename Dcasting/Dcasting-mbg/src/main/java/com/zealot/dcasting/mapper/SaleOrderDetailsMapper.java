package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.SaleOrderDetails;
import com.zealot.dcasting.model.SaleOrderDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderDetailsMapper {
    long countByExample(SaleOrderDetailsExample example);

    int deleteByExample(SaleOrderDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SaleOrderDetails record);

    int insertSelective(SaleOrderDetails record);

    List<SaleOrderDetails> selectByExample(SaleOrderDetailsExample example);

    SaleOrderDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SaleOrderDetails record, @Param("example") SaleOrderDetailsExample example);

    int updateByExample(@Param("record") SaleOrderDetails record, @Param("example") SaleOrderDetailsExample example);

    int updateByPrimaryKeySelective(SaleOrderDetails record);

    int updateByPrimaryKey(SaleOrderDetails record);
}