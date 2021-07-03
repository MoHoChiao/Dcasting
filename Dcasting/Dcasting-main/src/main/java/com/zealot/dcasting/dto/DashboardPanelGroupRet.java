package com.zealot.dcasting.dto;

public class DashboardPanelGroupRet {
	private Long inquiriesWaiting;
	private Long quotationsWaiting;
	private Long ordersWaiting;
	private Long projectsWaiting;
	
	public Long getInquiriesWaiting() {
		return inquiriesWaiting;
	}
	public void setInquiriesWaiting(Long inquiriesWaiting) {
		this.inquiriesWaiting = inquiriesWaiting;
	}
	public Long getQuotationsWaiting() {
		return quotationsWaiting;
	}
	public void setQuotationsWaiting(Long quotationsWaiting) {
		this.quotationsWaiting = quotationsWaiting;
	}
	public Long getProjectsWaiting() {
		return projectsWaiting;
	}
	public void setProjectsWaiting(Long projectsWaiting) {
		this.projectsWaiting = projectsWaiting;
	}
	public Long getOrdersWaiting() {
		return ordersWaiting;
	}
	public void setOrdersWaiting(Long ordersWaiting) {
		this.ordersWaiting = ordersWaiting;
	}
}
