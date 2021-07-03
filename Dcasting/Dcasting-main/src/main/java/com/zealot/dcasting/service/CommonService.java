package com.zealot.dcasting.service;

import com.zealot.dcasting.dto.UserAndGroupParamRet;

/**
 * 無權限的共用方法Service
 * Created by LeoLiu on 2021/6/9.
 */
public interface CommonService {
	/**
     * 根據inquiriesUserId及supplierUserId, 一次取得他們的username及groupname
     */
	UserAndGroupParamRet getUsernameAndGroupnameObj(Long inquiriesUserId, Long supplierUserId);
}
