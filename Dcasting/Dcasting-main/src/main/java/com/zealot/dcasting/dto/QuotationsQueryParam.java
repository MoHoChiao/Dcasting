package com.zealot.dcasting.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Inquiries查詢參數
 * Created by LeoLiu on 2021/5/24.
 */
public class QuotationsQueryParam {
	@ApiModelProperty(value = "關鍵字")
    private String keyword;
	@ApiModelProperty(value = "排序")
    private String orderByClause;
	@ApiModelProperty(value = "頁尺寸", required = true)
    private Integer pageSize;
	@ApiModelProperty(value = "頁數", required = true)
    private Integer pageNum;
	@ApiModelProperty(value = "報價單預計出貨日範圍")
    private Date[] estimatedDeliveryDates;
	@ApiModelProperty(value = "狀態")
    private String status;
	@ApiModelProperty(value = "使用者附加屬性", required = true)
    private String userType;
	@ApiModelProperty(value = "群組ID")
    private Long groupid;
	@ApiModelProperty(value = "使用者ID", required = true)
    private Long userid;
    
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Date[] getEstimatedDeliveryDates() {
		return estimatedDeliveryDates;
	}
	public void setEstimatedDeliveryDates(Date[] estimatedDeliveryDates) {
		this.estimatedDeliveryDates = estimatedDeliveryDates;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getGroupid() {
		return groupid;
	}
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
