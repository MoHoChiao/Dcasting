package com.zealot.dcasting.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 動態權限相關業務類
 * Created by LeoLiu on 2020/6/7.
 */
public interface DynamicSecurityService {
    /**
     * 加載權限ANT通配符和權限對應MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
