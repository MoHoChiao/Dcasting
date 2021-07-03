package com.zealot.dcasting.config;

import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.security.component.DynamicSecurityService;
import com.zealot.dcasting.security.config.SecurityConfig;
import com.zealot.dcasting.service.UmsPermissionService;
import com.zealot.dcasting.service.UmsUserService;

import cn.hutool.core.util.StrUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * D-Casting模塊相關配置
 * Created by LeoLiu on 2020/6/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DcastingSecurityConfig extends SecurityConfig {

    @Autowired
    private UmsUserService userService;
    @Autowired
    private UmsPermissionService permissionService;

    @Bean
    public UserDetailsService userDetailsService() {
        //獲取登錄使用者信息
        return username -> userService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<UmsPermission> permissionList = permissionService.listAll();
                for (UmsPermission permission : permissionList) {
                	if (!StrUtil.isEmpty(permission.getValue())) {
                		map.put(permission.getValue(), new org.springframework.security.access.SecurityConfig(permission.getId() + ":" + permission.getName()));
                	}
                }
                return map;
            }
        };
    }
}
