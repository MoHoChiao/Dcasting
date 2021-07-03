package com.zealot.dcasting.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置類
 * Created by LeoLiu on 2020/6/9.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.zealot.dcasting.mapper","com.zealot.dcasting.dao"})
public class MyBatisConfig {
}
