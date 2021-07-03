package com.zealot.dcasting.service.impl;

import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.QuotationDetailsDao;
import com.zealot.dcasting.dto.QuotationDetailsParamRet;
import com.zealot.dcasting.mapper.QuotationDetailsMapper;
import com.zealot.dcasting.mapper.QuotationsMapper;
import com.zealot.dcasting.mapper.SystemParamsMapper;
import com.zealot.dcasting.mapper.UmsUserMapper;
import com.zealot.dcasting.model.QuotationDetails;
import com.zealot.dcasting.model.QuotationDetailsExample;
import com.zealot.dcasting.model.Quotations;
import com.zealot.dcasting.model.QuotationsExample;
import com.zealot.dcasting.model.SystemParamsExample;
import com.zealot.dcasting.model.UmsUserExample;
import com.zealot.dcasting.service.QuotationDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 報價單明細Service實作
 * Created by LeoLiu on 2021/6/4.
 */
@Service
public class QuotationDetailsServiceImpl implements QuotationDetailsService {
    @Autowired
    private QuotationDetailsMapper quotationDetailsMapper;
    @Autowired
    private QuotationsMapper quotationsMapper;
    @Autowired
    private SystemParamsMapper systemParamsMapper;
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private QuotationDetailsDao quotationDetailsDao;
    
    @Override
    public List<QuotationDetails> listAll() {
    	QuotationDetailsExample example = new QuotationDetailsExample();
    	QuotationDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        example.setOrderByClause("id asc");
        return quotationDetailsMapper.selectByExample(example);
    }

    @Override
    public List<QuotationDetails> list(String quotationId, String orderByClause) {
        QuotationDetailsExample example = new QuotationDetailsExample();
        QuotationDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andQuotationIdEqualTo(quotationId);
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        
        return quotationDetailsMapper.selectByExample(example);
    }
    
    @Override
    public QuotationDetailsParamRet listAllQuotationDetailsParams() {
    	QuotationDetailsParamRet retList = new QuotationDetailsParamRet();
    	
    	SystemParamsExample example = new SystemParamsExample();
    	SystemParamsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andTypeEqualTo("quotation_details_item_category");
        example.setOrderByClause("id asc");
        retList.setItemCategory(systemParamsMapper.selectByExample(example));
        
        UmsUserExample exampleUser = new UmsUserExample();
        UmsUserExample.Criteria criteriaUser = exampleUser.createCriteria();
        criteriaUser.andFlagNotEqualTo(0);
        criteriaUser.andIsSupplierEqualTo("S");
        exampleUser.setOrderByClause("update_datetime desc");
        retList.setUserList(userMapper.selectByExample(exampleUser));
        
        return retList;
    }
    
    @Override
    public int create(QuotationDetails details) {
    	// 後端再次確認報價單存在,且狀態只能為草稿
    	this.isQuotationsStatusCanModify(details.getQuotationId());
    	details.setFlag(1);
    	int count = quotationDetailsMapper.insert(details);
    	count += this.totalByQuotationId(details.getQuotationId());
        return count;
    }

    @Override
    public int update(Long id, QuotationDetails details) {
    	this.isQuotationDetailsExist(id);	// 判斷報價單明細是否存在
    	this.isQuotationsStatusCanModify(details.getQuotationId());	// 後端再次確認報價單存在,且狀態只能為草稿
    	details.setId(id);
    	int count = quotationDetailsMapper.updateByPrimaryKeySelective(details);
    	count += this.totalByQuotationId(details.getQuotationId());
        return count;
    }

    @Override
    public int delete(Date update_datetime, Long update_user_id, Long id) {
    	QuotationDetails detail = this.isQuotationDetailsExist(id);	//判斷報價單明細是否存在
    	// 後端再次確認報價單狀態只能為草稿
    	this.isQuotationsStatusCanModify(detail.getQuotationId());
    	int count = quotationDetailsDao.deleteDetailsById(update_datetime, update_user_id, id);
    	count += this.totalByQuotationId(detail.getQuotationId());
        return count;
    }
    
    private QuotationDetails isQuotationDetailsExist(Long id) {
    	//判斷報價單明細是否存在
    	QuotationDetails quotationDetailsDB = quotationDetailsMapper.selectByPrimaryKey(id);
    	if (quotationDetailsDB == null || quotationDetailsDB.getFlag() == 0) {
    		Asserts.fail(ResultCode.QUOTATIONDETAILS_NOT_EXIST);
    	}
    	return quotationDetailsDB;
    }
    
    private void isQuotationsStatusCanModify(String quotationId) {
    	// 後端再次確認報價單存在,且狀態只能為草稿
    	QuotationsExample example = new QuotationsExample();
    	QuotationsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andQuotationStatusEqualTo("D");
        criteria.andQuotationIdEqualTo(quotationId);
        Long selectQuotationsCount = quotationsMapper.countByExample(example);
        if (selectQuotationsCount <= 0L) {
        	Asserts.fail(ResultCode.D_TO_Q_STATUS_FAIL);
        }
    }
    
    private int totalByQuotationId (String quotationId) {
    	Long total = quotationDetailsDao.sumByQuotationId(quotationId);
    	Quotations quotations = new Quotations();
    	quotations.setQuotationId(quotationId);
    	quotations.setAmount(total);
    	return quotationsMapper.updateByPrimaryKeySelective(quotations);
    }
}
