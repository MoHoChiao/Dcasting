package com.zealot.dcasting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zealot.dcasting.model.Mailer;

/**
 * 寄信Dao
 * Created by LeoLiu on 2021/6/17.
 */
public interface MailerDao {
    /**
     * 批量插入專案
     */
    int insertList(@Param("list")List<Mailer> list);
}
