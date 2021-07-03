package com.zealot.dcasting.service.impl;

import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.mapper.UmsPermissionCategoryMapper;
import com.zealot.dcasting.mapper.UmsPermissionMapper;
import com.zealot.dcasting.model.UmsPermissionCategory;
import com.zealot.dcasting.model.UmsPermissionCategoryExample;
import com.zealot.dcasting.model.UmsPermissionExample;
import com.zealot.dcasting.service.UmsPermissionCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 權限分類管理Service實作
 * Created by LeoLiu on 2020/6/8.
 */
@Service
public class UmsPermissionCategoryServiceImpl implements UmsPermissionCategoryService {
    @Autowired
    private UmsPermissionCategoryMapper permissionCategoryMapper;
    @Autowired
    private UmsPermissionMapper permissionMapper;

    @Override
    public List<UmsPermissionCategory> listAll() {
        UmsPermissionCategoryExample example = new UmsPermissionCategoryExample();
        example.setOrderByClause("sort asc");
        return permissionCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(UmsPermissionCategory umsPermissionCategory) {
        umsPermissionCategory.setCreateTime(new Date());
        return permissionCategoryMapper.insert(umsPermissionCategory);
    }

    @Override
    public int update(Long id, UmsPermissionCategory umsPermissionCategory) {
        umsPermissionCategory.setId(id);
        return permissionCategoryMapper.updateByPrimaryKeySelective(umsPermissionCategory);
    }

    @Override
    public int delete(Long id) {
    	UmsPermissionExample example = new UmsPermissionExample();
    	example.createCriteria().andCategoryIdEqualTo(id);
    	long count = permissionMapper.countByExample(example);
    	if (count > 0) {
    		Asserts.fail(ResultCode.DELETE_PERMISSION_FIRST);
    	}
        return permissionCategoryMapper.deleteByPrimaryKey(id);
    }
}
