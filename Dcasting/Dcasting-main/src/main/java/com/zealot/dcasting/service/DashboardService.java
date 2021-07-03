package com.zealot.dcasting.service;

import com.zealot.dcasting.dto.DashboardPanelGroupRet;
import com.zealot.dcasting.dto.DashboardPieRet;

/**
 * 首頁Service
 * Created by LeoLiu on 2021/6/17.
 */
public interface DashboardService {

    /**
     * 查詢PanelGroup
     */
	DashboardPanelGroupRet getPanelGroup(String usertype, Long userid, Long groupid);
	
	/**
     * 查詢詢價單PieChart
     */
	DashboardPieRet getInquiriesPie(String usertype, Long userid, Long groupid);
	
	/**
     * 查詢報價單PieChart
     */
	DashboardPieRet getQuotationsPie(String usertype, Long userid, Long groupid);
	
	/**
     * 查詢銷售訂單PieChart
     */
	DashboardPieRet getOrdersPie(String usertype, Long userid, Long groupid);
	
	/**
     * 查詢專案PieChart
     */
	DashboardPieRet getProjectsPie(String usertype, Long userid, Long groupid);
}
