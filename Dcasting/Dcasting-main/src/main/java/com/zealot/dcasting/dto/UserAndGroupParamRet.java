package com.zealot.dcasting.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserAndGroupParamRet {
	@ApiModelProperty(value = "詢價人及群組")
	private UmsUserRet inquiriesUser;
	@ApiModelProperty(value = "總承作廠商代表人及群組")
	private UmsUserRet supplierUser;
	
	public UmsUserRet getInquiriesUser() {
		return inquiriesUser;
	}
	public void setInquiriesUser(UmsUserRet inquiriesUser) {
		this.inquiriesUser = inquiriesUser;
	}
	public UmsUserRet getSupplierUser() {
		return supplierUser;
	}
	public void setSupplierUser(UmsUserRet supplierUser) {
		this.supplierUser = supplierUser;
	}
	
}
