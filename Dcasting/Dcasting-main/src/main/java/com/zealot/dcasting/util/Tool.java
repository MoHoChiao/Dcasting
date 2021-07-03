package com.zealot.dcasting.util;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zealot.dcasting.model.Mailer;

@Component
public class Tool {
	private AtomicInteger inquiriesInteger = new AtomicInteger();
	private AtomicInteger quotationsInteger = new AtomicInteger();
	private AtomicInteger ordersInteger = new AtomicInteger();
	private AtomicInteger projectsInteger = new AtomicInteger();
	@Value("${dataRange:6}")
    private int dataRange;
	
	public String generateRandomPassword(int len, int randNumOrigin, int randNumBound) {
		SecureRandom random = new SecureRandom();
        return random.ints(randNumOrigin, randNumBound + 1)
                .filter(i -> Character.isAlphabetic(i) || Character.isDigit(i))
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
	}
	
	public Mailer generateMailer(String category, String subject, String content, 
			String contentType, String from, String to, Long id, String username) {
		Mailer mailer = new Mailer();
        mailer.setCategory(category);
        mailer.setSubject(subject);
        mailer.setContent(content);
        mailer.setContenttype(contentType);
        mailer.setFrom(from);
        mailer.setTo(to);
        mailer.setCc("");
        mailer.setBcc("");
        mailer.setAttach("");
        Date now = new Date();
        mailer.setSendafter(now);
        mailer.setSendat(now);
        mailer.setSendcount(0);
        mailer.setBatchid(id);
        mailer.setXdate(now);
        mailer.setXuser(username);
        return mailer;
	}

	public Date[] getDataRange() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if (this.dataRange < 6) {
			this.dataRange = 6;
		} else if (this.dataRange > 12) {
			this.dataRange = 12;
		}
		
		Calendar calendar = Calendar.getInstance();
		//	下個月第一天當end date
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		Date endDate = calendar.getTime();
		try {
			endDate = sdf.parse((sdf.format(calendar.getTime())));
		} catch (ParseException e) {}
		//	根據設定檔取得要幾個月前
		calendar.add(Calendar.MONTH, -dataRange);
		Date startDate = calendar.getTime();
		try {
			startDate = sdf.parse(sdf.format(calendar.getTime()));
		} catch (ParseException e) {}
		
		return new Date[] {startDate, endDate};
	}
	
	public String addAndGetInquiriesId(int num) {
		Integer resultNum = inquiriesInteger.addAndGet(num);
		String resultNumString = resultNum.toString();
		if (resultNumString.length() == 1) {
			resultNumString = "00" + resultNumString;
		} else if (resultNumString.length() == 2) {
			resultNumString = "0" + resultNumString;
		}
		return resultNumString;
	}

	public void setInquiriesNum(int num) {
		this.inquiriesInteger.set(num);
	}
	
	public void inquiriesNumMinusOne () {
		this.setInquiriesNum(this.inquiriesInteger.get() - 1);
	}
	
	public String addAndGetQuotationsId(int num) {
		Integer resultNum = quotationsInteger.addAndGet(num);
		String resultNumString = resultNum.toString();
		if (resultNumString.length() == 1) {
			resultNumString = "00" + resultNumString;
		} else if (resultNumString.length() == 2) {
			resultNumString = "0" + resultNumString;
		}
		return resultNumString;
	}

	public void setQuotationsNum(int num) {
		this.quotationsInteger.set(num);
	}
	
	public void quotationsNumMinusOne () {
		this.setQuotationsNum(this.quotationsInteger.get() - 1);
	}
	
	public String addAndGetOrdersId(int num) {
		Integer resultNum = ordersInteger.addAndGet(num);
		String resultNumString = resultNum.toString();
		if (resultNumString.length() == 1) {
			resultNumString = "00" + resultNumString;
		} else if (resultNumString.length() == 2) {
			resultNumString = "0" + resultNumString;
		}
		return resultNumString;
	}

	public void setOrdersNum(int num) {
		this.ordersInteger.set(num);
	}
	
	public void ordersNumMinusOne () {
		this.setOrdersNum(this.ordersInteger.get() - 1);
	}
	
	public String addAndGetProjectsId(int num) {
		Integer resultNum = projectsInteger.addAndGet(num);
		String resultNumString = resultNum.toString();
		if (resultNumString.length() == 1) {
			resultNumString = "00" + resultNumString;
		} else if (resultNumString.length() == 2) {
			resultNumString = "0" + resultNumString;
		}
		return resultNumString;
	}

	public void setProjectsNum(int num) {
		this.projectsInteger.set(num);
	}
	
	public void projectsNumMinusOne () {
		this.setProjectsNum(this.projectsInteger.get() - 1);
	}
	
	public Integer getIdNum(String id) {
		String numStr = id.substring(7);
		return Integer.valueOf(numStr);
	}
	
	@Scheduled(cron = "1 0 0 * * ?")
	public void setAllNumToZero() {
		this.setInquiriesNum(0);
		this.setQuotationsNum(0);
		this.setOrdersNum(0);
		this.setProjectsNum(0);
	}
}
