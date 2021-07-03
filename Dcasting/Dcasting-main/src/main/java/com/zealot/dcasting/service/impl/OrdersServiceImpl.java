package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.OrderDetailsDao;
import com.zealot.dcasting.dao.OrdersDao;
import com.zealot.dcasting.dto.OrdersQueryParam;
import com.zealot.dcasting.mapper.SaleOrdersMapper;
import com.zealot.dcasting.model.SaleOrders;
import com.zealot.dcasting.model.SaleOrdersExample;
import com.zealot.dcasting.service.OrdersService;
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
 * 銷售訂單管理Service實作
 * Created by LeoLiu on 2021/6/6.
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private SaleOrdersMapper ordersMapper;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private Tool tool;
        
    @Override
    public List<SaleOrders> listAll() {
    	SaleOrdersExample example = new SaleOrdersExample();
    	SaleOrdersExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        // 取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        example.setOrderByClause("id asc");
        return ordersMapper.selectByExample(example);
    }
    
    @Override
    public List<SaleOrders> list(OrdersQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        SaleOrdersExample example = new SaleOrdersExample();
        SaleOrdersExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        // 取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        // 判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!queryParam.getUserType().equals("C")) {
        	if (!StringUtils.isEmpty(queryParam.getGroupid())) {	//若有groupId時, 則根據groupId取資料
            	criteria.andInquiryGroupIdEqualTo(queryParam.getGroupid());
            } else {	//沒有groupId時, 則根據userId取資料
            	criteria.andInquiryGroupIdIsNull();
            	criteria.andInquiryUserIdEqualTo(queryParam.getUserid());
            }
        }
        
        String keyword = queryParam.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("order_id", keyword);
        	map.put("inquiry_name", keyword);
        	criteria.multiColumnOrClause(map);
        }
        
        Date[] estimatedDeliveryDates = queryParam.getEstimatedDeliveryDates();
        if (estimatedDeliveryDates != null && estimatedDeliveryDates.length == 2) {
        	criteria.andEstimatedDeliveryDateBetween(estimatedDeliveryDates[0], estimatedDeliveryDates[1]);
        }
        
        String status = queryParam.getStatus();
        if (!StringUtils.isEmpty(status)) {
        	criteria.andOrderStatusEqualTo(status);
        }
        
        if (!StringUtils.isEmpty(queryParam.getOrderByClause())) {
        	example.setOrderByClause(queryParam.getOrderByClause());
        }
        
        return ordersMapper.selectByExample(example);
    }
    
    @Override
    public int create(SaleOrders orders) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String preString = "S" + sdf.format(new Date());
        	String postString = tool.addAndGetOrdersId(1);
        	String id = preString + postString;
        	if (id.length() > 10) {
        		Asserts.fail(ResultCode.ID_LENGTH_FAIL);
        	}
        	orders.setOrderId(id);
        	orders.setFlag(1);
        	int count = ordersMapper.insert(orders);
            return count;
    	} catch (Exception e) {
    		tool.ordersNumMinusOne();
    		throw e;
    	}
    }
    
    @Override
    public String createAndReturnId(SaleOrders orders) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String preString = "S" + sdf.format(new Date());
        	String postString = tool.addAndGetOrdersId(1);
        	String id = preString + postString;
        	if (id.length() > 10) {
        		Asserts.fail(ResultCode.ID_LENGTH_FAIL);
        	}
        	orders.setOrderId(id);
        	orders.setFlag(1);
        	ordersMapper.insert(orders);
            return id;
    	} catch (Exception e) {
    		tool.ordersNumMinusOne();
    		throw e;
    	}
    }

    @Override
    public int update(String id, SaleOrders orders) {
    	this.isOrdersExist(id);	// 判斷銷售訂單是否存在, 以及狀態不能為F(已結案)
    	orders.setOrderId(id);
    	int count = ordersMapper.updateByPrimaryKeySelective(orders);
        return count;
    }

    @Override
    public int updateStatus(Long userid, String status, String id) {
    	this.isOrdersExist(id);	// 判斷銷售訂單是否存在, 以及狀態不能為F(已結案)
    	SaleOrders orders = new SaleOrders();
    	orders.setOrderId(id);
    	orders.setUpdateDatetime(new Date());
    	orders.setUpdateUserId(userid);
    	orders.setOrderStatus(status);
    	int count = ordersMapper.updateByPrimaryKeySelective(orders);
        return count;
    }
    
    @Override
    public int delete(Date update_datetime, Long update_user_id, String id) {
    	this.isOrdersExist(id);	//判斷銷售訂單是否存在
    	int count = orderDetailsDao.deleteDetailsByOrderId(update_datetime, update_user_id, id);
    	count += ordersDao.deleteOrdersById(update_datetime, update_user_id, id);
        return count;
    }
    
    private SaleOrders isOrdersExist(String orderId) {
    	// 判斷銷售訂單是否存在, 以及狀態不能為F(已結案)
    	SaleOrders ordersDB = ordersMapper.selectByPrimaryKey(orderId);
    	if (ordersDB == null || ordersDB.getFlag() == 0 || ordersDB.getOrderStatus().equals("F")) {
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	}
    	return ordersDB;
    }
}
