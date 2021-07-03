package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.MailerDao;
import com.zealot.dcasting.dao.OrderDetailsDao;
import com.zealot.dcasting.dao.ProjectDetailsDao;
import com.zealot.dcasting.dto.QuotationsParamRet;
import com.zealot.dcasting.dto.QuotationsQueryParam;
import com.zealot.dcasting.mapper.InquiriesMapper;
import com.zealot.dcasting.mapper.MailerMapper;
import com.zealot.dcasting.mapper.QuotationDetailsMapper;
import com.zealot.dcasting.mapper.QuotationsMapper;
import com.zealot.dcasting.mapper.UmsGroupMapper;
import com.zealot.dcasting.mapper.UmsUserMapper;
import com.zealot.dcasting.model.Inquiries;
import com.zealot.dcasting.model.InquiriesExample;
import com.zealot.dcasting.model.Mailer;
import com.zealot.dcasting.model.ProjectDetails;
import com.zealot.dcasting.model.Projects;
import com.zealot.dcasting.model.QuotationDetails;
import com.zealot.dcasting.model.QuotationDetailsExample;
import com.zealot.dcasting.model.Quotations;
import com.zealot.dcasting.model.QuotationsExample;
import com.zealot.dcasting.model.SaleOrderDetails;
import com.zealot.dcasting.model.SaleOrders;
import com.zealot.dcasting.model.UmsGroup;
import com.zealot.dcasting.model.UmsUser;
import com.zealot.dcasting.model.UmsUserExample;
import com.zealot.dcasting.service.QuotationsService;
import com.zealot.dcasting.util.Tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 報價單管理Service實作
 * Created by LeoLiu on 2021/5/8.
 */
@Service
public class QuotationsServiceImpl implements QuotationsService {
    @Autowired
    private QuotationsMapper quotationsMapper;
    @Autowired
    private QuotationDetailsMapper quotationDetailsMapper;
    @Autowired
    private InquiriesMapper inquiriesMapper;
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private UmsGroupMapper groupMapper;
    @Autowired
    private MailerMapper mailMapper;
    @Autowired
    private MailerDao mailDao;
    @Autowired
    private QuotationDetailsServiceImpl quotationDetailsService;
    @Autowired
    private OrdersServiceImpl orderService;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private ProjectsServiceImpl projectService;
    @Autowired
    private ProjectDetailsDao projectDetailsDao;
    @Autowired
    private Tool tool;
    @Value("${systemMailSender}")
    private String systemMailSender;
    @Value("${systemMailRecipient}")
    private String systemMailRecipient;
    
    @Override
    public List<Quotations> listAll() {
    	QuotationsExample example = new QuotationsExample();
    	QuotationsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        //    	取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        example.setOrderByClause("id asc");
        return quotationsMapper.selectByExample(example);
    }

    @Override
    public QuotationsParamRet listAllQuotationsParams() {
    	QuotationsParamRet retList = new QuotationsParamRet();
    	
    	InquiriesExample exampleInquiries = new InquiriesExample();
    	InquiriesExample.Criteria criteriaInquiries = exampleInquiries.createCriteria();
    	criteriaInquiries.andFlagNotEqualTo(0);
    	//    	取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteriaInquiries.andCreateDatetimeBetween(range[0], range[1]);
    	List<String> status = new ArrayList<String>();
    	status.add("W");
    	status.add("R");
    	criteriaInquiries.andInquiryStatusIn(status);
        exampleInquiries.setOrderByClause("update_datetime desc");
        retList.setInquiresList(inquiriesMapper.selectByExample(exampleInquiries));
        
        UmsUserExample exampleUser = new UmsUserExample();
        UmsUserExample.Criteria criteriaUser = exampleUser.createCriteria();
        criteriaUser.andFlagNotEqualTo(0);
        criteriaUser.andIsSupplierEqualTo("S");
        exampleUser.setOrderByClause("update_datetime desc");
        retList.setUserList(userMapper.selectByExample(exampleUser));
        
        return retList;
    }
    
    @Override
    public List<Quotations> list(QuotationsQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        QuotationsExample example = new QuotationsExample();
        QuotationsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        //    	取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        //判斷用戶類型, C表示服務中心, 資料全show, 若為其它用戶, 則根據groupId(若有)或userId來取資料
        if (!queryParam.getUserType().equals("C")) {
        	if (!StringUtils.isEmpty(queryParam.getGroupid())) {	//若有groupId時, 則根據groupId取資料
            	criteria.andInquiryGroupIdEqualTo(queryParam.getGroupid());
            } else {	//沒有groupId時, 則根據userId取資料
            	criteria.andInquiryGroupIdIsNull();
            	criteria.andInquiryUserIdEqualTo(queryParam.getUserid());
            }
        	criteria.andQuotationStatusNotEqualTo("D");
        }
        
        String keyword = queryParam.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("quotation_id", keyword);
        	map.put("inquiry_name", keyword);
        	criteria.multiColumnOrClause(map);
        }
        
        Date[] estimatedDeliveryDates = queryParam.getEstimatedDeliveryDates();
        if (estimatedDeliveryDates != null && estimatedDeliveryDates.length == 2) {
        	criteria.andEstimatedDeliveryDateBetween(estimatedDeliveryDates[0], estimatedDeliveryDates[1]);
        }
        
        String status = queryParam.getStatus();
        if (!StringUtils.isEmpty(status)) {
        	criteria.andQuotationStatusEqualTo(status);
        }
        
        if (!StringUtils.isEmpty(queryParam.getOrderByClause())) {
        	example.setOrderByClause(queryParam.getOrderByClause());
        }
        
        return quotationsMapper.selectByExample(example);
    }
    
    @Override
    public int create(Quotations quotations) {
    	try {
    		// 後端再次確認對應的詢價單存在, 以及狀態只能為等待回覆或已報價
    		this.isInquiriesStatusCanModify(quotations.getInquiryId());
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String preString = "B" + sdf.format(new Date());
        	String postString = tool.addAndGetQuotationsId(1);
        	String id = preString + postString;
        	if (id.length() > 10) {
        		Asserts.fail(ResultCode.ID_LENGTH_FAIL);
        	}
        	quotations.setQuotationId(id);
        	quotations.setFlag(1);
        	int count = quotationsMapper.insert(quotations);
            return count;
    	} catch (Exception e) {
    		tool.quotationsNumMinusOne();
    		throw e;
    	}
    }

    @Override
    public int update(String id, Quotations quotations) {
		this.isInquiriesStatusCanModify(quotations.getInquiryId());	// 後端再次確認對應的詢價單存在, 以及狀態只能為等待回覆或已報價
    	Quotations quotationsDB = this.isQuotationsExist(id);	// 判斷報價單是否存在
        // 只要不是草稿, 都不能進行編輯
    	if (!quotationsDB.getQuotationStatus().equals("D")) {
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	}
    	quotations.setQuotationId(id);
    	int count = quotationsMapper.updateByPrimaryKeySelective(quotations);
        return count;
    }

    @Override
    public int updateStatus(Long userid, String status, String id) {
    	Quotations quotationsDB = this.isQuotationsExist(id);	//判斷報價單是否存在
    	if (quotationsDB.getQuotationStatus().equals("D")) {
    		if (!status.equals("W")) {	//如果DB裡是草稿, 只要傳來要改的不是等待回覆, 都不能編輯
    			Asserts.fail(ResultCode.STATUS_FAIL);
    		} else {
    			//	如果是合法的等待回覆, 後端再次檢查, 此報價單底下是否已建立明細
    			this.isAnyDetailsUnderQuotation(quotationsDB.getQuotationId());
    			//	如果是合法的等待回覆, 後端再次確認對應的詢價單存在, 以及狀態只能為等待回覆或已報價
    			this.isInquiriesStatusCanModify(quotationsDB.getInquiryId());
    			
    		}
    	} else if (quotationsDB.getQuotationStatus().equals("W")) {
    		UmsUser uesrDB = userMapper.selectByPrimaryKey(userid);
    		if (!uesrDB.getIsSupplier().equals("C")) {
    			if (!status.equals("Y") && !status.equals("N")) {	//如果DB裡是等待回覆且user為一般用戶, 只要傳來要改的不是Y和N, 都不能編輯
        			Asserts.fail(ResultCode.STATUS_FAIL);
        		}
    		} else {
    			if (!status.equals("C")) {	//如果DB裡是等待回覆且user為服務中心, 只要傳來要改的不是C, 都不能編輯
        			Asserts.fail(ResultCode.STATUS_FAIL);
        		}
    		}
    	} else if (quotationsDB.getQuotationStatus().equals("Y")) {	//Y為最終, 不可能再改變
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	} else if (quotationsDB.getQuotationStatus().equals("N")) {	//N為最終, 不可能再改變
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	} else if (quotationsDB.getQuotationStatus().equals("C")) {	//C為最終, 不可能再改變
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	}
    	
    	Quotations quotations = new Quotations();
    	quotations.setQuotationId(id);
    	quotations.setUpdateDatetime(new Date());
    	quotations.setUpdateUserId(userid);
    	quotations.setQuotationStatus(status);
    	int count = quotationsMapper.updateByPrimaryKeySelective(quotations);
    	
    	if (status.equals("Y")) {	// 已接受報價, 自動建立訂單(明細)及專案(明細)
    		this.createOrderProjectAndDetails(quotationsDB);
    	} else if (status.contentEquals("W")) {	// 寄信且自動把對應的詢價單狀態改成已報價
        	count += this.sendMailForWaitingAndChangeInquiriesStatus(quotationsDB);
    	}
        return count;
    }
    
    @Override
    public int delete(String id) {
    	// 後端再次確認報價單存在,且狀態只能為草稿
    	this.isQuotationsStatusCanDelete(id);
    	QuotationDetailsExample example = new QuotationDetailsExample();
    	QuotationDetailsExample.Criteria criteria = example.createCriteria();
    	criteria.andQuotationIdEqualTo(id);
    	int count = quotationDetailsMapper.deleteByExample(example);
    	count += quotationsMapper.deleteByPrimaryKey(id);
        return count;
    }
    
    private Quotations isQuotationsExist(String quotationId) {
    	// 判斷報價單是否存在
    	Quotations quotationsDB = quotationsMapper.selectByPrimaryKey(quotationId);
    	if (quotationsDB == null || quotationsDB.getFlag() == 0) {
    		Asserts.fail(ResultCode.QUOTATIONS_NOT_EXIST);
    	}
    	return quotationsDB;
    }
    
    private void isInquiriesStatusCanModify(String inquiryId) {
    	// 後端再次確認對應的詢價單存在, 以及狀態只能為等待回覆或已報價
    	InquiriesExample inquiriesExample = new InquiriesExample();
        InquiriesExample.Criteria inquiriesCriteria = inquiriesExample.createCriteria();
        inquiriesCriteria.andFlagNotEqualTo(0);
        List<String> status = new ArrayList<String>();
    	status.add("W");
    	status.add("R");
    	inquiriesCriteria.andInquiryStatusIn(status);
    	inquiriesCriteria.andInquiryIdEqualTo(inquiryId);
        Long selectInquiriesCount = inquiriesMapper.countByExample(inquiriesExample);
        if (selectInquiriesCount <= 0L) {
        	Asserts.fail(ResultCode.Q_TO_I_STATUS_FAIL);
        }
    }
    
    private void isAnyDetailsUnderQuotation(String quotationsId) {
        // 後端再次檢查, 此報價單底下是否已建立明細
        QuotationDetailsExample detailsExample = new QuotationDetailsExample();
        QuotationDetailsExample.Criteria detailsCriteria = detailsExample.createCriteria();
        detailsCriteria.andFlagNotEqualTo(0);
        detailsCriteria.andQuotationIdEqualTo(quotationsId);
        Long selectDetailsCount = quotationDetailsMapper.countByExample(detailsExample);
        if (selectDetailsCount <= 0L) {
        	Asserts.fail(ResultCode.NO_DETAILS_UNDER_QUOTATION);
        }
    }
    
    private void isQuotationsStatusCanDelete(String quotationId) {
    	// 後端再次確認報價單存在,且狀態只能為草稿
    	QuotationsExample example = new QuotationsExample();
    	QuotationsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andQuotationStatusEqualTo("D");
        criteria.andQuotationIdEqualTo(quotationId);
        Long selectInquiriesCount = quotationsMapper.countByExample(example);
        if (selectInquiriesCount <= 0L) {
        	Asserts.fail(ResultCode.STATUS_FAIL);
        }
    }
    
    private void createOrderProjectAndDetails(Quotations quotations) {
    	List<Mailer> mailList = new ArrayList<Mailer>();
    	
    	//	先建立銷售訂單以及專案的主體
    	UmsUser mainSupplier = userMapper.selectByPrimaryKey(quotations.getSupplierId());
    	//	建立銷售訂單
    	SaleOrders orders = new SaleOrders();
    	orders.setInquiryId(quotations.getInquiryId());
    	orders.setInquiryName(quotations.getInquiryName());
    	orders.setQuotationId(quotations.getQuotationId());
    	orders.setAmount(quotations.getAmount());
    	orders.setEstimatedDeliveryDate(quotations.getEstimatedDeliveryDate());
    	orders.setEstimatedArrivalDate(quotations.getEstimatedArrivalDate());
    	orders.setOrderStatus("W");
    	orders.setInquiryUserId(quotations.getInquiryUserId());
    	orders.setInquiryGroupId(quotations.getInquiryGroupId());
    	orders.setSupplierId(mainSupplier.getId());
    	orders.setSupplierGroupId(mainSupplier.getGroupId());
    	orders.setCreateDatetime(new Date());
    	orders.setUpdateDatetime(new Date());
    	orders.setCreateUserId(quotations.getCreateUserId());
    	orders.setUpdateUserId(quotations.getCreateUserId());
    	String orderId = orderService.createAndReturnId(orders);
    	//	建立銷售訂單的mail
    	orders.setOrderId(orderId);
    	mailList.add(this.getMailForCreateOrder(orders));
    	//	建立專案
    	Projects projects = new Projects();
    	projects.setInquiryId(quotations.getInquiryId());
    	projects.setInquiryName(quotations.getInquiryName());
    	projects.setQuotationId(quotations.getQuotationId());
    	projects.setProjectStatus(0);
    	projects.setProjectProgress("0%");
    	projects.setSupplierId(mainSupplier.getId());
    	projects.setSupplierGroupId(mainSupplier.getGroupId());
    	projects.setCreateDatetime(new Date());
    	projects.setUpdateDatetime(new Date());
    	projects.setCreateUserId(quotations.getCreateUserId());
    	projects.setUpdateUserId(quotations.getCreateUserId());
    	String projectId = projectService.createAndReturnId(projects);
    	//	建立專案的mail
    	projects.setProjectId(projectId);
    	mailList.add(this.getMailForCreateProject(projects));
    	
    	//	再建立銷售訂單明細以及專案工作項目
    	List<SaleOrderDetails> orderDetailsList = new ArrayList<SaleOrderDetails>();
    	List<ProjectDetails> projectDetailsList = new ArrayList<ProjectDetails>();
    	List<QuotationDetails> quotationDetailsList = quotationDetailsService.list(orders.getQuotationId(), null);
    	for (QuotationDetails quotationDetails : quotationDetailsList) {
    		UmsUser subSupplier = userMapper.selectByPrimaryKey(quotationDetails.getItemSupplierId());
    		//	銷售訂單明細的部份
    		SaleOrderDetails orderDetails = new SaleOrderDetails();
    		orderDetails.setOrderId(orderId);
    		orderDetails.setItemNumber(quotationDetails.getItemNumber());
    		orderDetails.setItemCategory(quotationDetails.getItemCategory());
    		orderDetails.setItemCaption(quotationDetails.getItemCaption());
    		orderDetails.setUnitPrice(quotationDetails.getUnitPrice());
    		orderDetails.setItemQuantity(quotationDetails.getItemQuantity());
    		orderDetails.setItemSubtotal(quotationDetails.getItemSubtotal());
    		orderDetails.setItemSupplierId(subSupplier.getId());
    		orderDetails.setItemSupplierGroupId(subSupplier.getGroupId());
    		orderDetails.setCreateDatetime(new Date());
    		orderDetails.setUpdateDatetime(new Date());
    		orderDetails.setCreateUserId(quotationDetails.getCreateUserId());
    		orderDetails.setUpdateUserId(quotationDetails.getCreateUserId());
    		orderDetails.setFlag(1);
    		orderDetailsList.add(orderDetails);
    		//	專案工作項目的部份
    		ProjectDetails projectDetails = new ProjectDetails();
    		projectDetails.setProjectId(projectId);
    		projectDetails.setInquiryId(quotations.getInquiryId());
    		projectDetails.setInquiryName(quotations.getInquiryName());
    		projectDetails.setDetailNumber(quotationDetails.getItemNumber());
    		projectDetails.setDetailCategory(quotationDetails.getItemCategory());
    		projectDetails.setDetailCaption(quotationDetails.getItemCaption());
    		projectDetails.setDetailProgress("0%");
    		projectDetails.setDetailSupplierId(subSupplier.getId());
    		projectDetails.setDetailSupplierGroupId(subSupplier.getGroupId());
    		projectDetails.setCreateDatetime(new Date());
    		projectDetails.setUpdateDatetime(new Date());
    		projectDetails.setCreateUserId(quotationDetails.getCreateUserId());
    		projectDetails.setUpdateUserId(quotationDetails.getCreateUserId());
    		projectDetails.setFlag(1);
    		projectDetailsList.add(projectDetails);
    		//	建立專案工作項目的mail
    		mailList.add(this.getMailForCreateProjectDetails(projectDetails));
    	}
    	//	把銷售訂單明細以及專案工作項目批量插入DB
    	if (orderDetailsList.size() > 0) {
    		orderDetailsDao.insertList(orderDetailsList);
    	}
    	if (projectDetailsList.size() > 0) {
    		projectDetailsDao.insertList(projectDetailsList);
    	}
    	
    	//	最後, 寄給服務中心及廠商, 通知銷售訂單及專案已建立
    	mailDao.insertList(mailList);
    }
    
    private int sendMailForWaitingAndChangeInquiriesStatus(Quotations quotations) {
    	UmsUser uesr = userMapper.selectByPrimaryKey(quotations.getInquiryUserId());
    	
		// 改變詢價單狀態
		Inquiries inquiries = new Inquiries();
		inquiries.setInquiryId(quotations.getInquiryId());
		inquiries.setInquiryStatus("R");
		InquiriesExample example = new InquiriesExample();
		InquiriesExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andInquiryStatusEqualTo("W");
        criteria.andInquiryIdEqualTo(quotations.getInquiryId());
        int count = inquiriesMapper.updateByExampleSelective(inquiries, example);
		
        //取得用戶及群組相關資訊
        UmsUser user = userMapper.selectByPrimaryKey(quotations.getInquiryUserId());
        String name = user.getUsername();
		Long id = user.getId();
		if (user.getGroupId() != null) {
			UmsGroup group = groupMapper.selectByPrimaryKey(user.getGroupId());
			name = group.getName();
			id = group.getId();
		}
		SimpleDateFormat sdfAllDate = new SimpleDateFormat("yyyy-MM-dd");
		String category = "quotationWaitingStatus";
		String subject = "D-casting 服務中心-"+name+" 您好, 您的的報價單("+quotations.getQuotationId()+")等待回覆中";
		String content = "用戶名稱:"+name+", 商品編號:"+quotations.getInquiryId()+", 商品名稱:"+quotations.getInquiryName()+
				", 報價總額:"+quotations.getAmount()+", 預計出貨日期:"+sdfAllDate.format(quotations.getEstimatedDeliveryDate())+
				", 預計到貨日期:"+sdfAllDate.format(quotations.getEstimatedArrivalDate());
		String contentType = "T";
		String from = systemMailSender;
		String to = uesr.getEmail();
		// 寄信
		Mailer mailer = tool.generateMailer(category, subject, content, contentType, from, to, id, "服務中心");
        count += mailMapper.insertSelective(mailer);
    	return count;
    }
    
    private Mailer getMailForCreateOrder(SaleOrders orders) {
    	//取得用戶及群組相關資訊
    	UmsUser user = userMapper.selectByPrimaryKey(orders.getInquiryUserId());
		String name = user.getUsername();
		Long id = user.getId();
		if (user.getGroupId() != null) {
			UmsGroup group = groupMapper.selectByPrimaryKey(user.getGroupId());
			name = group.getName();
			id = group.getId();
		}
		UmsUser supplier = userMapper.selectByPrimaryKey(orders.getSupplierId());
		String supplierName = supplier.getUsername();
		if (supplier.getGroupId() != null) {
			UmsGroup supplierGroup = groupMapper.selectByPrimaryKey(supplier.getGroupId());
			supplierName = supplierGroup.getName();
		}
    	
		String category = "createOrderNotify";
		String subject = "D-casting 服務中心-用戶 "+name+" 的銷售訂單("+orders.getOrderId()+")已建立, 目前狀態為準備中";
		String content = "用戶名稱:"+name+", 報價單編號:"+orders.getQuotationId()+", 商品編號:"+orders.getInquiryId()+", 商品名稱:"+orders.getInquiryName()+
				", 報價總額:"+orders.getAmount()+", 總承作廠商代表:"+supplierName;
		String contentType = "T";
		String from = user.getEmail();
		String to = systemMailRecipient;
    	return tool.generateMailer(category, subject, content, contentType, from, to, id, "服務中心");
    }
    
    private Mailer getMailForCreateProject(Projects projects) {
    	//取得用戶及群組相關資訊
		UmsUser supplier = userMapper.selectByPrimaryKey(projects.getSupplierId());
		String supplierName = supplier.getUsername();
		Long id = supplier.getId();
		if (supplier.getGroupId() != null) {
			UmsGroup supplierGroup = groupMapper.selectByPrimaryKey(supplier.getGroupId());
			supplierName = supplierGroup.getName();
			id = supplierGroup.getId();
		}
    	
		String category = "createProjectNotify";
		String subject = "D-casting 服務中心-廠商 "+supplierName+" 的新專案("+projects.getProjectId()+")已建立";
		String content = "商品名稱:"+projects.getInquiryName()+", 請您儘快至D-Casting更新專案資訊";
		String contentType = "T";
		String from = supplier.getEmail();
		String to = systemMailRecipient;
    	return tool.generateMailer(category, subject, content, contentType, from, to, id, "服務中心");
    }
    
    private Mailer getMailForCreateProjectDetails(ProjectDetails details) {
    	//取得用戶及群組相關資訊
		UmsUser supplier = userMapper.selectByPrimaryKey(details.getDetailSupplierId());
		String supplierName = supplier.getUsername();
		Long id = supplier.getId();
		if (supplier.getGroupId() != null) {
			UmsGroup supplierGroup = groupMapper.selectByPrimaryKey(supplier.getGroupId());
			supplierName = supplierGroup.getName();
			id = supplierGroup.getId();
		}
    	
		String category = "createProjectDetailNotify";
		String subject = "D-casting 服務中心-廠商 "+supplierName+" 的新專案工作項目("+details.getProjectId()+")已建立";
		String content = "商品名稱:"+details.getInquiryName()+", 請您儘快至D-Casting更新專案工作項目的資訊";
		String contentType = "T";
		String from = supplier.getEmail();
		String to = systemMailRecipient;
    	return tool.generateMailer(category, subject, content, contentType, from, to, id, "服務中心");
    }
}
