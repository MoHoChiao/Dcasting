package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.Inquiries;
import com.zealot.dcasting.model.InquiriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiriesMapper {
    long countByExample(InquiriesExample example);

    int deleteByExample(InquiriesExample example);

    int deleteByPrimaryKey(String inquiryId);

    int insert(Inquiries record);

    int insertSelective(Inquiries record);

    List<Inquiries> selectByExample(InquiriesExample example);

    Inquiries selectByPrimaryKey(String inquiryId);

    int updateByExampleSelective(@Param("record") Inquiries record, @Param("example") InquiriesExample example);

    int updateByExample(@Param("record") Inquiries record, @Param("example") InquiriesExample example);

    int updateByPrimaryKeySelective(Inquiries record);

    int updateByPrimaryKey(Inquiries record);
}