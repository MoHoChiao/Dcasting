package com.zealot.dcasting.dto;

import java.util.List;

import com.zealot.dcasting.model.Inquiries;
import com.zealot.dcasting.model.UmsUser;

import io.swagger.annotations.ApiModelProperty;

public class QuotationsParamRet {
	@ApiModelProperty(value = "詢價單列表")
	private List<Inquiries> inquiresList;
	@ApiModelProperty(value = "用戶列表")
	private List<UmsUser> userList;

	public List<Inquiries> getInquiresList() {
		return inquiresList;
	}

	public void setInquiresList(List<Inquiries> inquiresList) {
		this.inquiresList = inquiresList;
	}

	public List<UmsUser> getUserList() {
		return userList;
	}

	public void setUserList(List<UmsUser> userList) {
		this.userList = userList;
	}
	
	
}
