package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.SaleOrders;
import com.zealot.dcasting.model.SaleOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrdersMapper {
    long countByExample(SaleOrdersExample example);

    int deleteByExample(SaleOrdersExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(SaleOrders record);

    int insertSelective(SaleOrders record);

    List<SaleOrders> selectByExample(SaleOrdersExample example);

    SaleOrders selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") SaleOrders record, @Param("example") SaleOrdersExample example);

    int updateByExample(@Param("record") SaleOrders record, @Param("example") SaleOrdersExample example);

    int updateByPrimaryKeySelective(SaleOrders record);

    int updateByPrimaryKey(SaleOrders record);
}