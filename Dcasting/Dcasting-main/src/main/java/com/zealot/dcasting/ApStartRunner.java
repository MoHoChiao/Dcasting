package com.zealot.dcasting;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zealot.dcasting.dao.InquiriesDao;
import com.zealot.dcasting.dao.OrdersDao;
import com.zealot.dcasting.dao.ProjectsDao;
import com.zealot.dcasting.dao.QuotationsDao;
import com.zealot.dcasting.util.Tool;

@Component
@Order(1)
public class ApStartRunner implements ApplicationRunner {
	@Autowired
    private InquiriesDao inquiriesDao;
	@Autowired
    private QuotationsDao quotationsDao;
	@Autowired
    private OrdersDao ordersDao;
	@Autowired
    private ProjectsDao projectsDao;
	@Autowired
    private Tool tool;
		
	@Override
	public void run(ApplicationArguments args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		String preString = sdf.format(new Date());
		
		//Inquiries
		String inquiriesId = inquiriesDao.getLastId("A" + preString);
		if (inquiriesId != null) {
			tool.setInquiriesNum(tool.getIdNum(inquiriesId));
		} else {	// 表示資料表中的資料一定是空的
			tool.setInquiriesNum(0);
		}
		
		//Quotations
		String quotationsId = quotationsDao.getLastId("B" + preString);
		if (quotationsId != null) {
			tool.setQuotationsNum(tool.getIdNum(quotationsId));
		} else {	// 表示資料表中的資料一定是空的
			tool.setQuotationsNum(0);
		}
		
		//Orders
		String ordersId = ordersDao.getLastId("S" + preString);
		if (ordersId != null) {
			tool.setOrdersNum(tool.getIdNum(ordersId));
		} else {	// 表示資料表中的資料一定是空的
			tool.setOrdersNum(0);
		}
		
		//Projects
		String projectsId = projectsDao.getLastId("P" + preString);
		if (projectsId != null) {
			tool.setProjectsNum(tool.getIdNum(projectsId));
		} else {	// 表示資料表中的資料一定是空的
			tool.setProjectsNum(0);
		}
	}
	
}
