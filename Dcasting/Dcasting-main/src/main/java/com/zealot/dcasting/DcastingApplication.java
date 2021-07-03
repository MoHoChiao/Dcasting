package com.zealot.dcasting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 應用啟動入口
 * Created by LeoLiu on 2020/6/7.
 */
@SpringBootApplication
@EnableScheduling
public class DcastingApplication {
    public static void main(String[] args) {
        SpringApplication.run(DcastingApplication.class, args);
    }
}
