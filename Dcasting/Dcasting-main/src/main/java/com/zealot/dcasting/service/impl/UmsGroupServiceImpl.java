package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.UmsGroupDao;
import com.zealot.dcasting.mapper.InquiriesMapper;
import com.zealot.dcasting.mapper.ProjectsMapper;
import com.zealot.dcasting.mapper.QuotationsMapper;
import com.zealot.dcasting.mapper.SaleOrdersMapper;
import com.zealot.dcasting.mapper.UmsGroupMapper;
import com.zealot.dcasting.mapper.UmsUserMapper;
import com.zealot.dcasting.model.InquiriesExample;
import com.zealot.dcasting.model.ProjectsExample;
import com.zealot.dcasting.model.QuotationsExample;
import com.zealot.dcasting.model.SaleOrdersExample;
import com.zealot.dcasting.model.UmsGroup;
import com.zealot.dcasting.model.UmsGroupExample;
import com.zealot.dcasting.model.UmsUser;
import com.zealot.dcasting.model.UmsUserExample;
import com.zealot.dcasting.service.UmsGroupService;
import com.zealot.dcasting.service.UmsUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 群組管理Service實作
 * Created by LeoLiu on 2021/5/8.
 */
@Service
public class UmsGroupServiceImpl implements UmsGroupService {
    @Autowired
    private UmsGroupMapper groupMapper;
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private UmsGroupDao groupDao;
    @Autowired
    private InquiriesMapper inquiriesMapper;
    @Autowired
    private QuotationsMapper quotationsMapper;
    @Autowired
    private SaleOrdersMapper ordersMapper;
    @Autowired
    private ProjectsMapper projectsMapper;
    @Autowired
    private UmsUserService userService;
    
    @Override
    public List<UmsGroup> listAll() {
    	UmsGroupExample example = new UmsGroupExample();
    	UmsGroupExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        example.setOrderByClause("id asc");
        return groupMapper.selectByExample(example);
    }

    @Override
    public List<UmsGroup> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsGroupExample example = new UmsGroupExample();
        UmsGroupExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        if (!StringUtils.isEmpty(keyword)) {
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("name", keyword);
        	map.put("tel", keyword);
        	map.put("uniform_numbers", keyword);
        	criteria.multiColumnOrClause(map);
        }
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        
        return groupMapper.selectByExample(example);
    }
    
    @Override
    public int create(UmsGroup umsGroup) {
    	umsGroup.setFlag(1);
        return groupMapper.insert(umsGroup);
    }

    @Override
    public int update(Long id, UmsGroup umsGroup) {
    	umsGroup.setId(id);
        return groupMapper.updateByPrimaryKeySelective(umsGroup);
    }

    @Override
    public int delete(Date update_datetime, Long update_user_id, Long id) {
    	// 判斷此群組在詢價單上有沒有非最終狀態的單子(草稿或等待回覆)
    	InquiriesExample inquiriesExample = new InquiriesExample();
    	InquiriesExample.Criteria inquiriesCriteria = inquiriesExample.createCriteria();
    	inquiriesCriteria.andFlagNotEqualTo(0);
        List<String> inquiriesStatus = new ArrayList<String>();
        inquiriesStatus.add("D");
        inquiriesStatus.add("W");
        inquiriesCriteria.andInquiryStatusIn(inquiriesStatus);
        inquiriesCriteria.andInquiryGroupIdEqualTo(id);
        Long selectInquiriesCount = inquiriesMapper.countByExample(inquiriesExample);
        if (selectInquiriesCount > 0L) {
        	Asserts.fail(ResultCode.GROUP_INQUIRIES_PROCESSING);
        }
        // 判斷此群組在報價單上有沒有非最終狀態的單子(草稿或等待回覆)
        QuotationsExample quotationsExample = new QuotationsExample();
        QuotationsExample.Criteria quotationsCriteria = quotationsExample.createCriteria();
        quotationsCriteria.andFlagNotEqualTo(0);
        List<String> quotationsStatus = new ArrayList<String>();
        quotationsStatus.add("D");
        quotationsStatus.add("W");
        quotationsCriteria.andQuotationStatusIn(quotationsStatus);
        quotationsCriteria.andInquiryGroupIdEqualTo(id);
        Long selectQuotationsCount = quotationsMapper.countByExample(quotationsExample);
        if (selectQuotationsCount > 0L) {
        	Asserts.fail(ResultCode.GROUP_QUOTATIONS_PROCESSING);
        }
        // 判斷此群組在銷售訂單上有沒有非最終狀態的單子(準備中或製作中或已製作完成)
        SaleOrdersExample ordersExample = new SaleOrdersExample();
        SaleOrdersExample.Criteria ordersCriteria = ordersExample.createCriteria();
        ordersCriteria.andFlagNotEqualTo(0);
        List<String> ordersStatus = new ArrayList<String>();
        ordersStatus.add("W");
        ordersStatus.add("P");
        ordersStatus.add("E");
        ordersCriteria.andOrderStatusIn(ordersStatus);
        ordersCriteria.andInquiryGroupIdEqualTo(id);
        Long selectOrdersCount = ordersMapper.countByExample(ordersExample);
        if (selectOrdersCount > 0L) {
        	Asserts.fail(ResultCode.GROUP_ORDERS_PROCESSING);
        }
        // 判斷此群組在專案上有沒有非最終狀態的單子(等待啟動或執行中)
        ProjectsExample projectsExample = new ProjectsExample();
        ProjectsExample.Criteria projectsCriteria = projectsExample.createCriteria();
        projectsCriteria.andFlagNotEqualTo(0);
        projectsCriteria.andProjectStatusEqualTo(0);
        projectsCriteria.andSupplierGroupIdEqualTo(id);
        Long selectProjectsCount = projectsMapper.countByExample(projectsExample);
        if (selectProjectsCount > 0L) {
        	Asserts.fail(ResultCode.GROUP_PROJECTS_PROCESSING);
        }
    	
        // 找到此群組底下的所有User且刪除
        UmsUserExample userExample = new UmsUserExample();
        UmsUserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andFlagNotEqualTo(0);
        userCriteria.andGroupIdEqualTo(id);
        List<UmsUser> userList = userMapper.selectByExample(userExample);
        for (UmsUser user : userList) {
        	userService.delete(update_datetime, update_user_id, user.getId(), user.getUsername());
        }
        
        return groupDao.deleteGroupById(update_datetime, update_user_id, id);
    }
}
