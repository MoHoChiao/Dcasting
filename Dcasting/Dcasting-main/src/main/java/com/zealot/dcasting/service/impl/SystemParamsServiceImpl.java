package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.dao.SystemParamsDao;
import com.zealot.dcasting.mapper.SystemParamsMapper;
import com.zealot.dcasting.model.SystemParams;
import com.zealot.dcasting.model.SystemParamsExample;
import com.zealot.dcasting.service.SystemParamsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 系統參數管理Service實作
 * Created by LeoLiu on 2021/5/8.
 */
@Service
public class SystemParamsServiceImpl implements SystemParamsService {
    @Autowired
    private SystemParamsMapper systemParamsMapper;
    @Autowired
    private SystemParamsDao paramsDao;
        
    @Override
    public List<SystemParams> listAll(String type) {
    	SystemParamsExample example = new SystemParamsExample();
    	SystemParamsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andTypeEqualTo(type);
        example.setOrderByClause("id asc");
        return systemParamsMapper.selectByExample(example);
    }

    @Override
    public List<SystemParams> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum, String type) {
        PageHelper.startPage(pageNum, pageSize);
        SystemParamsExample example = new SystemParamsExample();
        SystemParamsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andTypeEqualTo(type);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        
        return systemParamsMapper.selectByExample(example);
    }
    
    @Override
    public int create(SystemParams systemParams) {
    	systemParams.setFlag(1);
        return systemParamsMapper.insert(systemParams);
    }

    @Override
    public int update(Long id, SystemParams systemParams) {
    	systemParams.setId(id);
        return systemParamsMapper.updateByPrimaryKeySelective(systemParams);
    }

    @Override
    public int delete(Date update_datetime, Long update_user_id, Long id) {
        return paramsDao.deleteSystemParamsById(update_datetime, update_user_id, id);
    }
}
