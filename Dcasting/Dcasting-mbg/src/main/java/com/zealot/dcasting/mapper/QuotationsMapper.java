package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.Quotations;
import com.zealot.dcasting.model.QuotationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuotationsMapper {
    long countByExample(QuotationsExample example);

    int deleteByExample(QuotationsExample example);

    int deleteByPrimaryKey(String quotationId);

    int insert(Quotations record);

    int insertSelective(Quotations record);

    List<Quotations> selectByExample(QuotationsExample example);

    Quotations selectByPrimaryKey(String quotationId);

    int updateByExampleSelective(@Param("record") Quotations record, @Param("example") QuotationsExample example);

    int updateByExample(@Param("record") Quotations record, @Param("example") QuotationsExample example);

    int updateByPrimaryKeySelective(Quotations record);

    int updateByPrimaryKey(Quotations record);
}