package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.ProjectDetailsDao;
import com.zealot.dcasting.dao.ProjectsDao;
import com.zealot.dcasting.dto.ProjectsQueryParam;
import com.zealot.dcasting.mapper.ProjectsMapper;
import com.zealot.dcasting.model.Projects;
import com.zealot.dcasting.model.ProjectsExample;
import com.zealot.dcasting.service.ProjectsService;
import com.zealot.dcasting.util.Tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 專案管理Service實作
 * Created by LeoLiu on 2021/6/9.
 */
@Service
public class ProjectsServiceImpl implements ProjectsService {
    @Autowired
    private ProjectsMapper projectsMapper;
    @Autowired
    private ProjectDetailsDao projectDetailsDao;
    @Autowired
    private ProjectsDao projectsDao;
    @Autowired
    private Tool tool;
        
    @Override
    public List<Projects> listAll() {
    	ProjectsExample example = new ProjectsExample();
    	ProjectsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        //    	取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        example.setOrderByClause("id asc");
        return projectsMapper.selectByExample(example);
    }
    
    @Override
    public List<Projects> list(ProjectsQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        ProjectsExample example = new ProjectsExample();
        ProjectsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        //    	取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        //判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!queryParam.getUserType().equals("C")) {
        	if (!StringUtils.isEmpty(queryParam.getGroupid())) {	//若有groupId時, 則根據groupId取資料
            	criteria.andSupplierGroupIdEqualTo(queryParam.getGroupid());
            } else {	//沒有groupId時, 則根據userId取資料
            	criteria.andSupplierGroupIdIsNull();
            	criteria.andSupplierIdEqualTo(queryParam.getUserid());
            }
        }
        
        String keyword = queryParam.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("project_id", keyword);
        	map.put("inquiry_name", keyword);
        	criteria.multiColumnOrClause(map);
        }
        
        Integer status = queryParam.getStatus();
        if (status != null && (status == 0 || status == 1)) {
        	criteria.andProjectStatusEqualTo(status);
        }
        
        String progress = queryParam.getProgress();
        if (!StringUtils.isEmpty(progress)) {
        	criteria.andProjectProgressEqualTo(progress);
        }
        
        if (!StringUtils.isEmpty(queryParam.getOrderByClause())) {
        	example.setOrderByClause(queryParam.getOrderByClause());
        }
        
        return projectsMapper.selectByExample(example);
    }
    
    @Override
    public int create(Projects projects) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String preString = "O" + sdf.format(new Date());
        	String postString = tool.addAndGetProjectsId(1);
        	String id = preString + postString;
        	if (id.length() > 10) {
        		Asserts.fail(ResultCode.ID_LENGTH_FAIL);
        	}
        	projects.setProjectId(id);
        	projects.setFlag(1);
        	int count = projectsMapper.insert(projects);
            return count;
    	} catch (Exception e) {
    		tool.projectsNumMinusOne();
    		throw e;
    	}
    }
    
    @Override
    public String createAndReturnId(Projects projects) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String preString = "P" + sdf.format(new Date());
        	String postString = tool.addAndGetProjectsId(1);
        	String id = preString + postString;
        	if (id.length() > 10) {
        		Asserts.fail(ResultCode.ID_LENGTH_FAIL);
        	}
        	projects.setProjectId(id);
        	projects.setFlag(1);
        	projectsMapper.insert(projects);
            return id;
    	} catch (Exception e) {
    		tool.projectsNumMinusOne();
    		throw e;
    	}
    }

    @Override
    public int update(String id, Projects projects) {
    	this.isProjectsExist(id);	//判斷專案是否存在
    	projects.setProjectId(id);
    	int count = projectsMapper.updateByPrimaryKeySelective(projects);
        return count;
    }

    @Override
    public int updateProgress(Long userid, String progress, String id) {
    	this.isProjectsExist(id);	//判斷專案是否存在
    	Projects projects = new Projects();
    	projects.setProjectId(id);
    	projects.setUpdateDatetime(new Date());
    	projects.setUpdateUserId(userid);
    	projects.setProjectProgress(progress);
    	int count = projectsMapper.updateByPrimaryKeySelective(projects);
        return count;
    }
    
    @Override
    public int updateStatus(Long userid, String id) {
    	this.isProjectsExist(id);	//判斷專案是否存在
    	Projects projects = new Projects();
    	projects.setProjectId(id);
    	projects.setUpdateDatetime(new Date());
    	projects.setUpdateUserId(userid);
    	projects.setProjectStatus(1);
    	int count = projectsMapper.updateByPrimaryKeySelective(projects);
        return count;
    }
    
    @Override
    public int delete(Date update_datetime, Long update_user_id, String id) {
    	this.isProjectsExist(id);	//判斷專案是否存在
    	int count = projectDetailsDao.deleteDetailsByProjectId(update_datetime, update_user_id, id);
    	count += projectsDao.deleteProjectsById(update_datetime, update_user_id, id);
        return count;
    }
    
    private Projects isProjectsExist(String projectId) {
    	//判斷專案是否存在
    	Projects projectsDB = projectsMapper.selectByPrimaryKey(projectId);
    	if (projectsDB == null || projectsDB.getFlag() == 0 || projectsDB.getProjectStatus() == 1) {
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	}
    	return projectsDB;
    }
}
