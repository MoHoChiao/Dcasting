package com.zealot.dcasting.service.impl;

import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.ProjectDetailsDao;
import com.zealot.dcasting.mapper.ProjectDetailsMapper;
import com.zealot.dcasting.model.ProjectDetails;
import com.zealot.dcasting.model.ProjectDetailsExample;
import com.zealot.dcasting.service.ProjectDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 專案明細Service實作
 * Created by LeoLiu on 2021/6/9.
 */
@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
    @Autowired
    private ProjectDetailsMapper projectDetailsMapper;
    @Autowired
    private ProjectDetailsDao projectDetailsDao;
    
    @Override
    public List<ProjectDetails> listAll() {
    	ProjectDetailsExample example = new ProjectDetailsExample();
    	ProjectDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        example.setOrderByClause("id asc");
        return projectDetailsMapper.selectByExample(example);
    }

    @Override
    public List<ProjectDetails> list(String projectId, String orderByClause) {
    	ProjectDetailsExample example = new ProjectDetailsExample();
    	ProjectDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andProjectIdEqualTo(projectId);
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        
        return projectDetailsMapper.selectByExample(example);
    }
    
    @Override
    public int create(ProjectDetails details) {
    	details.setFlag(1);
    	int count = projectDetailsMapper.insert(details);
        return count;
    }

    @Override
    public int update(Long id, ProjectDetails details) {
    	this.isProjectDetailsExist(id);	//判斷專案工作項目是否存在
    	details.setId(id);
    	int count = projectDetailsMapper.updateByPrimaryKeySelective(details);
        return count;
    }

    @Override
    public int delete(Date update_datetime, Long update_user_id, Long id) {
    	this.isProjectDetailsExist(id);	//判斷專案工作項目是否存在
    	int count = projectDetailsDao.deleteDetailsById(update_datetime, update_user_id, id);
        return count;
    }
    
    @Override
    public int updateProgress(Long userid, String progress, Long id) {
    	this.isProjectDetailsExist(id);	//判斷專案工作項目是否存在
    	ProjectDetails details = new ProjectDetails();
    	details.setId(id);
    	details.setUpdateDatetime(new Date());
    	details.setUpdateUserId(userid);
    	details.setDetailProgress(progress);
    	int count = projectDetailsMapper.updateByPrimaryKeySelective(details);
        return count;
    }
    
    private ProjectDetails isProjectDetailsExist(Long id) {
    	//判斷專案工作項目是否存在
    	ProjectDetails projectDetailsDB = projectDetailsMapper.selectByPrimaryKey(id);
    	if (projectDetailsDB == null || projectDetailsDB.getFlag() == 0) {
    		Asserts.fail(ResultCode.PROJECTDETAILS_NOT_EXIST);
    	}
    	return projectDetailsDB;
    }
}
