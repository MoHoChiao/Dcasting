package com.zealot.dcasting.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

/**
 * 自定義詢價單管理Dao
 * Created by LeoLiu on 2021/5/7.
 */
public interface DashboardDao {
	/**
     * 取得服務中心用戶的詢價單狀態統計
     */
	@MapKey("inquiry_status")
	Map<String, HashMap<String, Long>> getInquiriesStatusCountByCenter(Date startDate, Date endDate);
	
	/**
     * 取得不是服務中心用戶的詢價單狀態統計
     */
	@MapKey("inquiry_status")
	Map<String, HashMap<String, Long>> getInquiriesStatusCountByNotCenter(Date startDate, Date endDate, Long groupid);
	
	/**
     * 取得不是服務中心用戶且無群組的詢價單狀態統計
     */
	@MapKey("inquiry_status")
	Map<String, HashMap<String, Long>> getInquiriesStatusCountByNotCenterAndGroupNull(Date startDate, Date endDate, Long userid);
	
	/**
     * 取得服務中心用戶的報價單狀態統計
     */
	@MapKey("quotation_status")
	Map<String, HashMap<String, Long>> getQuotationsStatusCountByCenter(Date startDate, Date endDate);
	
	/**
     * 取得不是服務中心用戶的報價單狀態統計
     */
	@MapKey("quotation_status")
	Map<String, HashMap<String, Long>> getQuotationsStatusCountByNotCenter(Date startDate, Date endDate, Long groupid);
	
	/**
     * 取得不是服務中心用戶且無群組的報價單狀態統計
     */
	@MapKey("quotation_status")
	Map<String, HashMap<String, Long>> getQuotationsStatusCountByNotCenterAndGroupNull(Date startDate, Date endDate, Long userid);
	
	/**
     * 取得服務中心用戶的詢銷售訂單狀態統計
     */
	@MapKey("order_status")
	Map<String, HashMap<String, Long>> getOrdersStatusCountByCenter(Date startDate, Date endDate);
	
	/**
     * 取得不是服務中心用戶的詢銷售訂單狀態統計
     */
	@MapKey("order_status")
	Map<String, HashMap<String, Long>> getOrdersStatusCountByNotCenter(Date startDate, Date endDate, Long groupid);
	
	/**
     * 取得不是服務中心用戶且無群組的銷售訂單狀態統計
     */
	@MapKey("order_status")
	Map<String, HashMap<String, Long>> getOrdersStatusCountByNotCenterAndGroupNull(Date startDate, Date endDate, Long userid);
	
	/**
     * 取得服務中心用戶的專案狀態統計
     */
	@MapKey("project_progress")
	Map<String, HashMap<String, Long>> getProjectProgressCountByCenter(Date startDate, Date endDate);
	
	/**
     * 取得不是服務中心用戶的專案狀態統計
     */
	@MapKey("project_progress")
	Map<String, HashMap<String, Long>> getProjectProgressCountByNotCenter(Date startDate, Date endDate, Long groupid);
	
	/**
     * 取得不是服務中心用戶且無群組的專案狀態統計
     */
	@MapKey("project_progress")
	Map<String, HashMap<String, Long>> getProjectProgressCountByNotCenterAndGroupNull(Date startDate, Date endDate, Long userid);
}
