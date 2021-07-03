package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.QuotationDetails;
import com.zealot.dcasting.model.QuotationDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuotationDetailsMapper {
    long countByExample(QuotationDetailsExample example);

    int deleteByExample(QuotationDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuotationDetails record);

    int insertSelective(QuotationDetails record);

    List<QuotationDetails> selectByExample(QuotationDetailsExample example);

    QuotationDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuotationDetails record, @Param("example") QuotationDetailsExample example);

    int updateByExample(@Param("record") QuotationDetails record, @Param("example") QuotationDetailsExample example);

    int updateByPrimaryKeySelective(QuotationDetails record);

    int updateByPrimaryKey(QuotationDetails record);
}