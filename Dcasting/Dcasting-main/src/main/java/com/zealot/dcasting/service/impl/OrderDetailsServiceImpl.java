package com.zealot.dcasting.service.impl;

import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.OrderDetailsDao;
import com.zealot.dcasting.mapper.SaleOrderDetailsMapper;
import com.zealot.dcasting.mapper.SaleOrdersMapper;
import com.zealot.dcasting.model.SaleOrderDetails;
import com.zealot.dcasting.model.SaleOrderDetailsExample;
import com.zealot.dcasting.model.SaleOrdersExample;
import com.zealot.dcasting.service.OrderDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 銷售訂單明細Service實作
 * Created by LeoLiu on 2021/6/6.
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private SaleOrderDetailsMapper orderDetailsMapper;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private SaleOrdersMapper ordersMapper;
    
    @Override
    public List<SaleOrderDetails> listAll() {
    	SaleOrderDetailsExample example = new SaleOrderDetailsExample();
    	SaleOrderDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        example.setOrderByClause("id asc");
        return orderDetailsMapper.selectByExample(example);
    }

    @Override
    public List<SaleOrderDetails> list(String orderId, String orderByClause) {
    	SaleOrderDetailsExample example = new SaleOrderDetailsExample();
    	SaleOrderDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andOrderIdEqualTo(orderId);
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        
        return orderDetailsMapper.selectByExample(example);
    }
    
    @Override
    public int create(SaleOrderDetails details) {
    	details.setFlag(1);
    	int count = orderDetailsMapper.insert(details);
        return count;
    }

    @Override
    public int update(Long id, SaleOrderDetails details) {
    	this.isOrderDetailsExist(id);	//判斷銷售訂單明細是否存在
    	this.isOrdersStatusCanModify(details.getOrderId());	// 判斷銷售訂單明細對應的銷售訂單狀態不可以為"F"(已結案)
    	details.setId(id);
    	int count = orderDetailsMapper.updateByPrimaryKeySelective(details);
        return count;
    }

    @Override
    public int delete(Date update_datetime, Long update_user_id, Long id) {
    	this.isOrderDetailsExist(id);	//判斷銷售訂單明細是否存在
    	int count = orderDetailsDao.deleteDetailsById(update_datetime, update_user_id, id);
        return count;
    }
    
    private SaleOrderDetails isOrderDetailsExist(Long id) {
    	// 判斷銷售訂單明細是否存在
    	SaleOrderDetails orderDetailsDB = orderDetailsMapper.selectByPrimaryKey(id);
    	if (orderDetailsDB == null || orderDetailsDB.getFlag() == 0) {
    		Asserts.fail(ResultCode.ORDERDETAILS_NOT_EXIST);
    	}
    	return orderDetailsDB;
    }
    
    private void isOrdersStatusCanModify(String orderId) {
    	// 判斷銷售訂單明細對應的銷售訂單狀態不可以為"F"(已結案)
    	SaleOrdersExample example = new SaleOrdersExample();
        SaleOrdersExample.Criteria criteria = example.createCriteria();        
        criteria.andFlagNotEqualTo(0);
        criteria.andOrderStatusNotEqualTo("F");
        criteria.andOrderIdEqualTo(orderId);
        Long selectOrdersCount = ordersMapper.countByExample(example);
        if (selectOrdersCount <= 0L) {
        	Asserts.fail(ResultCode.D_TO_O_STATUS_FAIL);
        }
    }
}
