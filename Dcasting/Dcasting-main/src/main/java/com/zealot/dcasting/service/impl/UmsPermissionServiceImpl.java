package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.dao.UmsRoleDao;
import com.zealot.dcasting.dao.UmsRolePermissionRelationDao;
import com.zealot.dcasting.dao.UmsUserPermissionRelationDao;
import com.zealot.dcasting.dao.UmsUserRoleRelationDao;
import com.zealot.dcasting.mapper.UmsPermissionMapper;
import com.zealot.dcasting.mapper.UmsRolePermissionRelationMapper;
import com.zealot.dcasting.mapper.UmsUserPermissionRelationMapper;
import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsPermissionExample;
import com.zealot.dcasting.model.UmsRolePermissionRelation;
import com.zealot.dcasting.model.UmsRolePermissionRelationExample;
import com.zealot.dcasting.model.UmsUserPermissionRelation;
import com.zealot.dcasting.model.UmsUserPermissionRelationExample;
import com.zealot.dcasting.service.UmsPermissionService;
import com.zealot.dcasting.service.UmsUserCacheService;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用者權限管理Service實作
 * Created by LeoLiu on 2020/6/8.
 */
@Service
public class UmsPermissionServiceImpl implements UmsPermissionService {
    @Autowired
    private UmsPermissionMapper permissionMapper;
    @Autowired
    private UmsUserPermissionRelationMapper userPermissionRelationMapper;
    @Autowired
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private UmsRoleDao roleDao;
    @Autowired
    private UmsUserRoleRelationDao userRoleRelationDao;
    @Autowired
    private UmsUserPermissionRelationDao userPermissionRelationDao;
    @Autowired
    private UmsRolePermissionRelationDao rolePermissionRelationDao;
    @Autowired
    private UmsUserCacheService userCacheService;

    @Override
    public int create(UmsPermission permission) {
        permission.setStatus(1);
        permission.setCreateTime(new Date());
        permission.setSort(0);
        return permissionMapper.insert(permission);
    }

    @Override
    public int update(Long id, UmsPermission permission) {
        permission.setId(id);
        int count = permissionMapper.updateByPrimaryKeySelective(permission);
        userCacheService.delPermissionListByPermission(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        // 刪除permission
        int count = permissionMapper.deleteByPrimaryKey(id);
        // 刪除redis中的permissionList時, 用到user_permission及role_permission關係, 所以要先做再刪除它們的關係
        userCacheService.delPermissionListByPermission(id);
        // 刪除user_permission關係
    	UmsUserPermissionRelationExample uprExample = new UmsUserPermissionRelationExample();
    	uprExample.createCriteria().andPermissionIdEqualTo(id);
    	userPermissionRelationMapper.deleteByExample(uprExample);
    	// 刪除role_permission關係
    	UmsRolePermissionRelationExample rprExample = new UmsRolePermissionRelationExample();
    	rprExample.createCriteria().andPermissionIdEqualTo(id);
    	rolePermissionRelationMapper.deleteByExample(rprExample);
        return count;
    }

    @Override
    public UmsPermission getItem(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<UmsPermission> list(Long categoryId, String nameKeyword, String valueKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UmsPermissionExample example = new UmsPermissionExample();
        UmsPermissionExample.Criteria criteria = example.createCriteria();
        if(categoryId!=null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andNameLike('%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(valueKeyword)){
            criteria.andValueLike('%'+valueKeyword+'%');
        }
        return permissionMapper.selectByExample(example);
    }

    @Override
    public List<UmsPermission> listAll() {
    	UmsPermissionExample example = new UmsPermissionExample();
    	example.setOrderByClause("category_id asc");
        return permissionMapper.selectByExample(example);
    }
    
    @Override
    public List<UmsPermission> getPermissionListByUserId(Long userId) {
        List<UmsPermission> permissionList = userCacheService.getPermissionList(userId);
        if(CollUtil.isNotEmpty(permissionList)){
            return  permissionList;
        }
        permissionList = userRoleRelationDao.getPermissionList(userId);
        if(CollUtil.isNotEmpty(permissionList)){
            userCacheService.setPermissionList(userId, permissionList);
        }
        return permissionList;
    }
    
    @Override
    public List<UmsPermission> getPermissionListByRoleId(Long roleId) {
        return roleDao.getPermissionListByRoleId(roleId);
    }
    
    @Override
    public int allocPermissionToUser(Long userId, List<Long> permissionIds) {
        //刪除原所有權限關係
        UmsUserPermissionRelationExample relationExample = new UmsUserPermissionRelationExample();
        relationExample.createCriteria().andUserIdEqualTo(userId);
        userPermissionRelationMapper.deleteByExample(relationExample);
        //獲取使用者所有角色權限
        List<UmsPermission> permissionList = userRoleRelationDao.getRolePermissionList(userId);
        List<Long> rolePermissionList = permissionList.stream().map(UmsPermission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<UmsUserPermissionRelation> relationList = new ArrayList<>();
            //篩選出+權限 (使用者比其角色多的權限)
            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //篩選出-權限 (使用者比其角色少的權限
            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //插入+-權限關係
            relationList.addAll(convert(userId, 1, addPermissionIdList));
            relationList.addAll(convert(userId, -1, subPermissionIdList));
            if(relationList.size() > 0) {	// 如果為空, 表示目前使用者的權限和使用者所屬的角色之權限, 兩者剛好是一樣的, 此時若不判斷會出錯
            	int count = userPermissionRelationDao.insertList(relationList);
                userCacheService.delPermissionList(userId);
                return count;
            } else {	// 略過relationList為空時, 傳回給controller會顥示分配錯誤, 所以回傳1
            	userCacheService.delPermissionList(userId);
            	return 1;
            }
        }
        return 0;
    }
    
    @Override
    public int allocPermissionToRole(Long roleId, List<Long> permissionIds) {
    	//先刪除原有關係
        UmsRolePermissionRelationExample example=new UmsRolePermissionRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(example);
        //批量插入新關係
        List<UmsRolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            UmsRolePermissionRelation relation = new UmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        
        if(relationList.size() > 0) {
        	int count = rolePermissionRelationDao.insertList(relationList);
            userCacheService.delPermissionListByRole(roleId);
            return count;
        } else {
        	userCacheService.delPermissionListByRole(roleId);
        	return 1;
        }
    }
    
    /**
     * 將+-權限關係轉化為對象
     */
    private List<UmsUserPermissionRelation> convert(Long userId,Integer type,List<Long> permissionIdList) {
        List<UmsUserPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
            UmsUserPermissionRelation relation = new UmsUserPermissionRelation();
            relation.setUserId(userId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
        return relationList;
    }
}
