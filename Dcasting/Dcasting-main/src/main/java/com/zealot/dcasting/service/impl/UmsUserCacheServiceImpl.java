package com.zealot.dcasting.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import com.zealot.dcasting.dao.UmsUserPermissionRelationDao;
import com.zealot.dcasting.dao.UmsUserRoleRelationDao;
import com.zealot.dcasting.mapper.UmsUserRoleRelationMapper;
import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsUser;
import com.zealot.dcasting.model.UmsUserRoleRelation;
import com.zealot.dcasting.model.UmsUserRoleRelationExample;
import com.zealot.dcasting.security.service.RedisService;
import com.zealot.dcasting.service.UmsUserCacheService;
import com.zealot.dcasting.service.UmsUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UmsUserCacheService實作
 * Created by LeoLiu on 2020/6/8.
 */
@Service
public class UmsUserCacheServiceImpl implements UmsUserCacheService {
    @Autowired
    private UmsUserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsUserRoleRelationMapper userRoleRelationMapper;
    @Autowired
    private UmsUserPermissionRelationDao userPermissionRelationDao;
    @Autowired
    private UmsUserRoleRelationDao userRoleRelationDao;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.user}")
    private String REDIS_KEY_USER;
    @Value("${redis.key.permissionList}")
    private String REDIS_KEY_PERMISSION_LIST;

    @Override
    public void delUser(Long userId) {
        UmsUser user = userService.getItem(userId);
        if (user != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_USER + ":" + user.getUsername();
            redisService.del(key);
        }
    }
    
    @Override
    public void delUser(String username) {
    	if (!StrUtil.isEmpty(username)) {
    		String key = REDIS_DATABASE + ":" + REDIS_KEY_USER + ":" + username;
            redisService.del(key);
    	}
    }

    @Override
    public void delPermissionList(Long userId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":" + userId;
        redisService.del(key);
    }

    @Override
    public void delPermissionListByRole(Long roleId) {
        UmsUserRoleRelationExample example = new UmsUserRoleRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<UmsUserRoleRelation> relationList = userRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getUserId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delPermissionListByRoleIds(List<Long> roleIds) {
        UmsUserRoleRelationExample example = new UmsUserRoleRelationExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<UmsUserRoleRelation> relationList = userRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getUserId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delPermissionListByPermission(Long permissionId) {
    	// 取得在role中的permission之userid
        List<Long> userIdList = userRoleRelationDao.getUserIdList(permissionId);
        // 取得在user中的permission之userid
        userIdList.addAll(userPermissionRelationDao.getUserIdList(permissionId));
        if (CollUtil.isNotEmpty(userIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":";
            List<String> keys = userIdList.stream().map(userId -> keyPrefix + userId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public UmsUser getUser(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_USER + ":" + username;
        return (UmsUser) redisService.get(key);
    }

    @Override
    public void setUser(UmsUser user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_USER + ":" + user.getUsername();
        redisService.set(key, user, REDIS_EXPIRE);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long userId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":" + userId;
        return (List<UmsPermission>) redisService.get(key);
    }

    @Override
    public void setPermissionList(Long userId, List<UmsPermission> permissionList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_PERMISSION_LIST + ":" + userId;
        redisService.set(key, permissionList, REDIS_EXPIRE);
    }
    
    @Override
    public void setExpireByUser(Long expireTime, String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_USER + ":" + username;
        redisService.expire(key, expireTime);
    }
}
