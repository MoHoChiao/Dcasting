package com.zealot.dcasting.service.impl;

import com.zealot.dcasting.dao.DashboardDao;
import com.zealot.dcasting.dto.DashboardPanelGroupRet;
import com.zealot.dcasting.dto.DashboardPieRet;
import com.zealot.dcasting.mapper.InquiriesMapper;
import com.zealot.dcasting.mapper.ProjectsMapper;
import com.zealot.dcasting.mapper.QuotationsMapper;
import com.zealot.dcasting.mapper.SaleOrdersMapper;
import com.zealot.dcasting.model.InquiriesExample;
import com.zealot.dcasting.model.ProjectsExample;
import com.zealot.dcasting.model.QuotationsExample;
import com.zealot.dcasting.model.SaleOrdersExample;
import com.zealot.dcasting.service.DashboardService;
import com.zealot.dcasting.util.Tool;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 首頁管理Service實作
 * Created by LeoLiu on 2021/6/17.
 */
@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private InquiriesMapper inquiriesMapper;
    @Autowired
    private DashboardDao dashboardDao;
    @Autowired
    private QuotationsMapper quotationsMapper;
    @Autowired
    private SaleOrdersMapper ordersMapper;
    @Autowired
    private ProjectsMapper projectsMapper;
    @Autowired
    private Tool tool;
    
    @Override
    public DashboardPanelGroupRet getPanelGroup(String usertype, Long userid, Long groupid) {
    	//    	取得資料時間範圍
        Date[] range = tool.getDataRange();
    	// 計算詢價單中的等待回覆數量
        InquiriesExample inquiriesExample = new InquiriesExample();
        InquiriesExample.Criteria inquiriesCriteria = inquiriesExample.createCriteria();
        inquiriesCriteria.andFlagNotEqualTo(0);
        inquiriesCriteria.andCreateDatetimeBetween(range[0], range[1]);
        //判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		inquiriesCriteria.andInquiryGroupIdEqualTo(groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	inquiriesCriteria.andInquiryGroupIdIsNull();
            	inquiriesCriteria.andInquiryUserIdEqualTo(userid);
            }
        }
        inquiriesCriteria.andInquiryStatusEqualTo("W");
        Long inquiriesCount = inquiriesMapper.countByExample(inquiriesExample);
    	
    	// 計算報價單中的等待回覆數量
    	QuotationsExample quotationsExample = new QuotationsExample();
        QuotationsExample.Criteria quotationsCriteria = quotationsExample.createCriteria();
        quotationsCriteria.andFlagNotEqualTo(0);
        quotationsCriteria.andCreateDatetimeBetween(range[0], range[1]);
        //判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		quotationsCriteria.andInquiryGroupIdEqualTo(groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	quotationsCriteria.andInquiryGroupIdIsNull();
            	quotationsCriteria.andInquiryUserIdEqualTo(userid);
            }
        }
        quotationsCriteria.andQuotationStatusEqualTo("W");
        Long quotationsCount = quotationsMapper.countByExample(quotationsExample);
        
    	// 計算銷售訂單中的準備中數量
    	SaleOrdersExample ordersExample = new SaleOrdersExample();
        SaleOrdersExample.Criteria ordersCriteria = ordersExample.createCriteria();
        ordersCriteria.andFlagNotEqualTo(0);
        ordersCriteria.andCreateDatetimeBetween(range[0], range[1]);
        //判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		ordersCriteria.andInquiryGroupIdEqualTo(groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	ordersCriteria.andInquiryGroupIdIsNull();
            	ordersCriteria.andInquiryUserIdEqualTo(userid);
            }
        }
        ordersCriteria.andOrderStatusEqualTo("W");
        Long ordersCount = ordersMapper.countByExample(ordersExample);
    	
    	// 計算專案中的未結案的數量
    	ProjectsExample projectsExample = new ProjectsExample();
        ProjectsExample.Criteria projectsCriteria = projectsExample.createCriteria();
        projectsCriteria.andFlagNotEqualTo(0);
        projectsCriteria.andCreateDatetimeBetween(range[0], range[1]);
        //判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		projectsCriteria.andSupplierGroupIdEqualTo(groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	projectsCriteria.andSupplierGroupIdIsNull();
            	projectsCriteria.andSupplierIdEqualTo(userid);
            }
        }
        projectsCriteria.andProjectStatusEqualTo(0);
        Long projectsCount = projectsMapper.countByExample(projectsExample);
        
        DashboardPanelGroupRet ret = new DashboardPanelGroupRet();
        ret.setInquiriesWaiting(inquiriesCount);
        ret.setQuotationsWaiting(quotationsCount);
        ret.setOrdersWaiting(ordersCount);
        ret.setProjectsWaiting(projectsCount);
        return ret;
    }
    
    @Override
    public DashboardPieRet getInquiriesPie(String usertype, Long userid, Long groupid) {
    	//    	取得資料時間範圍
        Date[] range = tool.getDataRange();
    	Map<String, HashMap<String, Long>> statusMap = new HashMap<String, HashMap<String,Long>>();
        //	判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		statusMap = dashboardDao.getInquiriesStatusCountByNotCenter(range[0], range[1], groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	statusMap = dashboardDao.getInquiriesStatusCountByNotCenterAndGroupNull(range[0], range[1], userid);
            }
        } else {
        	statusMap = dashboardDao.getInquiriesStatusCountByCenter(range[0], range[1]);
        }
        
        List<String> labelList = new ArrayList<String>();
        // 計算詢價單中各個狀態的數量
        Long draftNum = null;
        HashMap<String, Long> draftMap = statusMap.get("D");
        if (!usertype.equals("C")) {
        	labelList.add("form.select.draft");
        	draftNum = draftMap != null ? draftMap.get("count") : 0L;
        }
        
        HashMap<String, Long> waitingMap = statusMap.get("W");
        Long waitingNum = waitingMap != null ? waitingMap.get("count") : 0L;
        labelList.add("form.select.waiting");
        
        HashMap<String, Long> repliedMap = statusMap.get("R");
        Long repliedNum = repliedMap != null ? repliedMap.get("count") : 0L;
        labelList.add("form.select.replied");
        
        HashMap<String, Long> cancelledMap = statusMap.get("C");
        Long cancelledNum = cancelledMap != null ? cancelledMap.get("count") : 0L;
        labelList.add("form.select.cancelled");
    	
        DashboardPieRet ret = new DashboardPieRet();
        ret.setLabelList(labelList);
        ret.setDraft(draftNum);
        ret.setWaiting(waitingNum);
        ret.setReplied(repliedNum);
        ret.setCancelled(cancelledNum);
        return ret;
    }
    
    @Override
    public DashboardPieRet getQuotationsPie(String usertype, Long userid, Long groupid) {
    	//    	取得資料時間範圍
        Date[] range = tool.getDataRange();
    	Map<String, HashMap<String, Long>> statusMap = new HashMap<String, HashMap<String,Long>>();
        //	判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		statusMap = dashboardDao.getQuotationsStatusCountByNotCenter(range[0], range[1], groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	statusMap = dashboardDao.getQuotationsStatusCountByNotCenterAndGroupNull(range[0], range[1], userid);
            }
        } else {
        	statusMap = dashboardDao.getQuotationsStatusCountByCenter(range[0], range[1]);
        }
        
        List<String> labelList = new ArrayList<String>();
        // 計算報價單中各個狀態的數量
        Long draftNum = null;
        HashMap<String, Long> draftMap = statusMap.get("D");
        if (usertype.equals("C")) {
        	labelList.add("form.select.draft");
        	draftNum = draftMap != null ? draftMap.get("count") : 0L;
        }
        
        HashMap<String, Long> waitingMap = statusMap.get("W");
        Long waitingNum = waitingMap != null ? waitingMap.get("count") : 0L;
        labelList.add("form.select.waiting");
        
        HashMap<String, Long> yesMap = statusMap.get("Y");
        Long yesNum = yesMap != null ? yesMap.get("count") : 0L;
        labelList.add("form.select.yes");
        
        HashMap<String, Long> noMap = statusMap.get("N");
        Long noNum = noMap != null ? noMap.get("count") : 0L;
        labelList.add("form.select.no");
        
        HashMap<String, Long> cancelledMap = statusMap.get("C");
        Long cancelledNum = cancelledMap != null ? cancelledMap.get("count") : 0L;
        labelList.add("form.select.cancelled");
    	
        DashboardPieRet ret = new DashboardPieRet();
        ret.setLabelList(labelList);
        ret.setDraft(draftNum);
        ret.setWaiting(waitingNum);
        ret.setYes(yesNum);
        ret.setNo(noNum);
        ret.setCancelled(cancelledNum);
        return ret;
    }
    
    @Override
    public DashboardPieRet getOrdersPie(String usertype, Long userid, Long groupid) {
    	//    	取得資料時間範圍
        Date[] range = tool.getDataRange();
    	Map<String, HashMap<String, Long>> statusMap = new HashMap<String, HashMap<String,Long>>();
        //	判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		statusMap = dashboardDao.getOrdersStatusCountByNotCenter(range[0], range[1], groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	statusMap = dashboardDao.getOrdersStatusCountByNotCenterAndGroupNull(range[0], range[1], userid);
            }
        } else {
        	statusMap = dashboardDao.getOrdersStatusCountByCenter(range[0], range[1]);
        }
        
        List<String> labelList = new ArrayList<String>();
        // 計算銷售訂單中各個狀態的數量
        HashMap<String, Long> readyMap = statusMap.get("W");
        Long readyNum = readyMap != null ? readyMap.get("count") : 0L;
        labelList.add("form.select.ready");
        
        HashMap<String, Long> processingMap = statusMap.get("P");
        Long processingNum = processingMap != null ? processingMap.get("count") : 0L;
        labelList.add("form.select.processing");
        
        HashMap<String, Long> endMap = statusMap.get("E");
        Long endNum = endMap != null ? endMap.get("count") : 0L;
        labelList.add("form.select.end");
        
        HashMap<String, Long> shippingMap = statusMap.get("S");
        Long shippingNum = shippingMap != null ? shippingMap.get("count") : 0L;
        labelList.add("form.select.shipping");
        
        HashMap<String, Long> finishMap = statusMap.get("F");
        Long finishNum = finishMap != null ? finishMap.get("count") : 0L;
        labelList.add("form.select.finish");
    	
        DashboardPieRet ret = new DashboardPieRet();
        ret.setLabelList(labelList);
        ret.setReady(readyNum);
        ret.setProcessing(processingNum);
        ret.setEnd(endNum);
        ret.setShipping(shippingNum);
        ret.setFinish(finishNum);
        return ret;
    }
    
    @Override
    public DashboardPieRet getProjectsPie(String usertype, Long userid, Long groupid) {
    	//    	取得資料時間範圍
        Date[] range = tool.getDataRange();
    	Map<String, HashMap<String, Long>> progressMap = new HashMap<String, HashMap<String,Long>>();
    	//判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!usertype.equals("C")) {
        	if (!StringUtils.isEmpty(groupid)) {	//若有groupId時, 則根據groupId取資料
        		progressMap = dashboardDao.getProjectProgressCountByNotCenter(range[0], range[1], groupid);
            } else {	//沒有groupId時, 則根據userId取資料
            	progressMap = dashboardDao.getProjectProgressCountByNotCenterAndGroupNull(range[0], range[1], userid);
            }
        } else {
        	progressMap = dashboardDao.getProjectProgressCountByCenter(range[0], range[1]);
        }
        
        List<String> labelList = new ArrayList<String>();
        // 計算銷售訂單中各個狀態的數量
        HashMap<String, Long> zeroMap = progressMap.get("0%");
        Long zeroPercent = zeroMap != null ? zeroMap.get("count") : 0L;
        labelList.add("0%");
        
        HashMap<String, Long> twentyFiveMap = progressMap.get("25%");
        Long twentyFivePercent = twentyFiveMap != null ? twentyFiveMap.get("count") : 0L;
        labelList.add("25%");
        
        HashMap<String, Long> fiftyMap = progressMap.get("50%");
        Long fiftyPercent = fiftyMap != null ? fiftyMap.get("count") : 0L;
        labelList.add("50%");
        
        HashMap<String, Long> seventyFiveMap = progressMap.get("75%");
        Long seventyFivePercent = seventyFiveMap != null ? seventyFiveMap.get("count") : 0L;
        labelList.add("75%");
        
        HashMap<String, Long> oneHundredMap = progressMap.get("100%");
        Long oneHundredPercent = oneHundredMap != null ? oneHundredMap.get("count") : 0L;
        labelList.add("100%");
    	
        DashboardPieRet ret = new DashboardPieRet();
        ret.setLabelList(labelList);
        ret.setZeroPercent(zeroPercent);
        ret.setTwentyFivePercent(twentyFivePercent);
        ret.setFiftyPercent(fiftyPercent);
        ret.setSeventyFivePercent(seventyFivePercent);
        ret.setOneHundredPercent(oneHundredPercent);
        return ret;
    }
}
