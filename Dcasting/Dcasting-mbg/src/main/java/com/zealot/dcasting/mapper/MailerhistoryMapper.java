package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.Mailerhistory;
import com.zealot.dcasting.model.MailerhistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailerhistoryMapper {
    long countByExample(MailerhistoryExample example);

    int deleteByExample(MailerhistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mailerhistory record);

    int insertSelective(Mailerhistory record);

    List<Mailerhistory> selectByExample(MailerhistoryExample example);

    Mailerhistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mailerhistory record, @Param("example") MailerhistoryExample example);

    int updateByExample(@Param("record") Mailerhistory record, @Param("example") MailerhistoryExample example);

    int updateByPrimaryKeySelective(Mailerhistory record);

    int updateByPrimaryKey(Mailerhistory record);
}