package com.zealot.dcasting.service.impl;

import com.zealot.dcasting.dao.UmsUserDao;
import com.zealot.dcasting.dto.UserAndGroupParamRet;
import com.zealot.dcasting.service.CommonService;
import com.zealot.dcasting.dto.UmsUserRet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 銷售訂單管理Service實作
 * Created by LeoLiu on 2021/6/6.
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private UmsUserDao userDao;
    
    @Override
    public UserAndGroupParamRet getUsernameAndGroupnameObj(Long inquiriesUserId, Long supplierUserId) {
    	UserAndGroupParamRet ret = new UserAndGroupParamRet();
    	
    	UmsUserRet inquiriesUser = userDao.selectByPrimaryKey(inquiriesUserId);
    	UmsUserRet supplierUser = userDao.selectByPrimaryKey(supplierUserId);
    	ret.setInquiriesUser(inquiriesUser);
    	ret.setSupplierUser(supplierUser);
        return ret;
    }
}
