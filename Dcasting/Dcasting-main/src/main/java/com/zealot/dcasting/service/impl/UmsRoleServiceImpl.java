package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.UmsRoleDao;
import com.zealot.dcasting.dao.UmsUserRoleRelationDao;
import com.zealot.dcasting.mapper.UmsRoleMapper;
import com.zealot.dcasting.mapper.UmsRolePermissionRelationMapper;
import com.zealot.dcasting.mapper.UmsUserRoleRelationMapper;
import com.zealot.dcasting.model.*;
import com.zealot.dcasting.service.UmsRoleService;
import com.zealot.dcasting.service.UmsUserCacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色管理Service實作
 * Created by LeoLiu on 2020/6/8.
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
	@Autowired
    private UmsRoleDao roleDao;
    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsUserRoleRelationMapper userRoleRelationMapper;
    @Autowired
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private UmsUserRoleRelationDao userRoleRelationDao;
    @Autowired
    private UmsUserCacheService userCacheService;
    @Override
    public int create(UmsRole umsRole) {
        umsRole.setFlag(1);
        umsRole.setSort(0);
        return roleMapper.insert(umsRole);
    }

    @Override
    public int update(Long id, UmsRole umsRole) {
        umsRole.setId(id);
        return roleMapper.updateByPrimaryKeySelective(umsRole);
    }

    @Override
    public int updateStatus(UmsRole role) {
    	role.setUpdateDatetime(new Date());
        int count = roleMapper.updateByPrimaryKeySelective(role);
        userCacheService.delPermissionListByRole(role.getId());
        return count;
    }
    
    @Override
    public int delete(Date update_datetime, Long update_user_id, List<Long> ids) {
    	// 刪除role
    	int count = 0;
    	if (ids != null && ids.size() > 0) {
    		long id = ids.get(0);
    		count = roleDao.deleteRoleByIds(update_datetime, update_user_id, id);
    	} else {
    		Asserts.fail(ResultCode.ID_EMPTY);
    	}
        // 刪除redis中的permissionList時, 會用到user_role關係, 所以要先做再刪除它們的關係
        userCacheService.delPermissionListByRoleIds(ids);
        // 刪除user_role關係
    	UmsUserRoleRelationExample urrExample = new UmsUserRoleRelationExample();
    	urrExample.createCriteria().andRoleIdIn(ids);
    	userRoleRelationMapper.deleteByExample(urrExample);
    	// 刪除role_permission關係
    	UmsRolePermissionRelationExample rprExample = new UmsRolePermissionRelationExample();
    	rprExample.createCriteria().andRoleIdIn(ids);
    	rolePermissionRelationMapper.deleteByExample(rprExample);
        return count;
    }

    @Override
    public List<UmsRole> getRoleListByUserId(Long userId) {
        return userRoleRelationDao.getRoleList(userId);
    }

    @Override
    public List<UmsRole> listAll() {
    	UmsRoleExample example = new UmsRoleExample();
    	UmsRoleExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<UmsRole> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsRoleExample example = new UmsRoleExample();
        UmsRoleExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        if (!StringUtils.isEmpty(keyword)) {
        	criteria.andNameLike("%" + keyword + "%");
        }
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public int allocRole(Long userId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先刪除原來的關係
        UmsUserRoleRelationExample userRoleRelationExample = new UmsUserRoleRelationExample();
        userRoleRelationExample.createCriteria().andUserIdEqualTo(userId);
        userRoleRelationMapper.deleteByExample(userRoleRelationExample);
        //建立新關係
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsUserRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsUserRoleRelation roleRelation = new UmsUserRoleRelation();
                roleRelation.setUserId(userId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            userRoleRelationDao.insertList(list);
        }
        userCacheService.delPermissionList(userId);
        return count;
    }
}
