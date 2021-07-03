package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.Mailer;
import com.zealot.dcasting.model.MailerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailerMapper {
    long countByExample(MailerExample example);

    int deleteByExample(MailerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mailer record);

    int insertSelective(Mailer record);

    List<Mailer> selectByExample(MailerExample example);

    Mailer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mailer record, @Param("example") MailerExample example);

    int updateByExample(@Param("record") Mailer record, @Param("example") MailerExample example);

    int updateByPrimaryKeySelective(Mailer record);

    int updateByPrimaryKey(Mailer record);
}