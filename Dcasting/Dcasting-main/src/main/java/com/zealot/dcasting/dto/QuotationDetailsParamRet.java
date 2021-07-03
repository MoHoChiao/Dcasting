package com.zealot.dcasting.dto;

import java.util.List;

import com.zealot.dcasting.model.SystemParams;
import com.zealot.dcasting.model.UmsUser;

import io.swagger.annotations.ApiModelProperty;

public class QuotationDetailsParamRet {
	@ApiModelProperty(value = "作業類別")
	private List<SystemParams> itemCategory;
	@ApiModelProperty(value = "用戶列表")
	private List<UmsUser> userList;

	public List<SystemParams> getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(List<SystemParams> itemCategory) {
		this.itemCategory = itemCategory;
	}

	public List<UmsUser> getUserList() {
		return userList;
	}

	public void setUserList(List<UmsUser> userList) {
		this.userList = userList;
	}
}
