package com.zealot.dcasting.dto;

import java.util.List;

import com.zealot.dcasting.model.SystemParams;

import io.swagger.annotations.ApiModelProperty;

public class InquiriesParamRet {
	@ApiModelProperty(value = "服務事項列表")
	private List<SystemParams> serviceCategory;
	@ApiModelProperty(value = "材料列表")
	private List<SystemParams> materialType;
	@ApiModelProperty(value = "付款方式列表")
	private List<SystemParams> payment;
	
	public List<SystemParams> getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(List<SystemParams> serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public List<SystemParams> getMaterialType() {
		return materialType;
	}
	public void setMaterialType(List<SystemParams> materialType) {
		this.materialType = materialType;
	}
	public List<SystemParams> getPayment() {
		return payment;
	}
	public void setPayment(List<SystemParams> payment) {
		this.payment = payment;
	}
}
