package com.zealot.dcasting.service.impl;

import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.InquiriesDao;
import com.zealot.dcasting.dto.InquiriesQueryParam;
import com.zealot.dcasting.dto.InquiriesParamRet;
import com.zealot.dcasting.mapper.InquiriesMapper;
import com.zealot.dcasting.mapper.MailerMapper;
import com.zealot.dcasting.mapper.SystemParamsMapper;
import com.zealot.dcasting.mapper.UmsGroupMapper;
import com.zealot.dcasting.mapper.UmsUserMapper;
import com.zealot.dcasting.model.Inquiries;
import com.zealot.dcasting.model.InquiriesExample;
import com.zealot.dcasting.model.Mailer;
import com.zealot.dcasting.model.SystemParamsExample;
import com.zealot.dcasting.model.UmsGroup;
import com.zealot.dcasting.model.UmsUser;
import com.zealot.dcasting.service.InquiriesService;
import com.zealot.dcasting.util.Tool;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * 詢價單管理Service實作
 * Created by LeoLiu on 2021/5/8.
 */
@Service
public class InquiriesServiceImpl implements InquiriesService {
    @Autowired
    private InquiriesMapper inquiriesMapper;
    @Autowired
    private SystemParamsMapper systemParamsMapper;
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private UmsGroupMapper groupMapper;
    @Autowired
    private MailerMapper mailMapper;
    @Autowired
    private InquiriesDao inquiriesDao;
    @Autowired
    private Tool tool;
    @Value("${systemMailRecipient}")
    private String systemMailRecipient;
    @Value("${fileUploadRootPath:\\}")
    private String fileUploadRootPath;
    private String separator = File.separator;
    
    @Override
    public Inquiries getById(String inquiryId) {
        return inquiriesMapper.selectByPrimaryKey(inquiryId);
    }
    
    @Override
    public List<Inquiries> listAll() {
    	InquiriesExample example = new InquiriesExample();
    	InquiriesExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        //    	取得資料時間範圍
        Date[] range = tool.getDataRange();
        criteria.andCreateDatetimeBetween(range[0], range[1]);
        example.setOrderByClause("id asc");
        return inquiriesMapper.selectByExample(example);
    }

    @Override
    public InquiriesParamRet listAllInquiriesParams() {
    	InquiriesParamRet retList = new InquiriesParamRet();
    	
    	SystemParamsExample example = new SystemParamsExample();
    	SystemParamsExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andTypeEqualTo("inquiries_service_category");
        example.setOrderByClause("id asc");
        retList.setServiceCategory(systemParamsMapper.selectByExample(example));
        
        example.clear();
        criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andTypeEqualTo("inquiries_material_type");
        example.setOrderByClause("id asc");
        retList.setMaterialType(systemParamsMapper.selectByExample(example));
        
        example.clear();
        criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andTypeEqualTo("inquiries_payment");
        example.setOrderByClause("id asc");
        retList.setPayment(systemParamsMapper.selectByExample(example));
        
        return retList;
    }
    
    @Override
    public List<Inquiries> list(InquiriesQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        InquiriesExample example = new InquiriesExample();
        InquiriesExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        //	取得資料時間範圍
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
        } else {
        	criteria.andInquiryStatusNotEqualTo("D");
        }
        
        String keyword = queryParam.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("inquiry_id", keyword);
        	map.put("product_name", keyword);
        	map.put("service_category", keyword);
        	map.put("material_type", keyword);
        	map.put("payment", keyword);
        	criteria.multiColumnOrClause(map);
        }
        
        Date[] requirementDates = queryParam.getRequirementDates();
        if (requirementDates != null && requirementDates.length == 2) {
        	criteria.andRequirementDateBetween(requirementDates[0], requirementDates[1]);
        }
        
        String status = queryParam.getStatus();
        if (!StringUtils.isEmpty(status)) {
        	criteria.andInquiryStatusEqualTo(status);
        }
        
        if (!StringUtils.isEmpty(queryParam.getOrderByClause())) {
        	example.setOrderByClause(queryParam.getOrderByClause());
        }
        
        return inquiriesMapper.selectByExample(example);
    }
    
    @Override
    public int create(Inquiries inquiries) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String preString = "A" + sdf.format(new Date());
        	String postString = tool.addAndGetInquiriesId(1);
        	String id = preString + postString;
        	if (id.length() > 10) {
        		Asserts.fail(ResultCode.ID_LENGTH_FAIL);
        	}
        	inquiries.setInquiryId(id);
        	inquiries.setFlag(1);
        	int count = inquiriesMapper.insert(inquiries);
            return count;
    	} catch (Exception e) {
    		tool.inquiriesNumMinusOne();
    		throw e;
    	}
    }

    @Override
    public int update(String id, Inquiries inquiries) {
    	Inquiries inquiriesDB = this.isInquiriesExist(id);	//判斷詢價單是否存在
    	if (!inquiriesDB.getInquiryStatus().equals("D")) {	//只要不是草稿, 都不能進行編輯
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	}
    	inquiries.setInquiryId(id);
    	int count = inquiriesMapper.updateByPrimaryKeySelective(inquiries);
        return count;
    }

    @Override
    public int updateStatus(Long userid, String status, String id) {
    	Inquiries inquiriesDB = this.isInquiriesExist(id);	//判斷詢價單是否存在
    	if (inquiriesDB.getInquiryStatus().equals("D")) {
    		if (!status.equals("W")) {	//如果DB裡是草稿, 只要傳來要改的不是等待回覆, 都不能編輯
    			Asserts.fail(ResultCode.STATUS_FAIL);
    		}
    	} else if (inquiriesDB.getInquiryStatus().equals("W")) {
    		UmsUser uesrDB = userMapper.selectByPrimaryKey(userid);
    		if (uesrDB.getIsSupplier().equals("C")) {
    			if (!status.equals("R")) {	//如果DB裡是等待回覆且user為服務中心, 只要傳來要改的不是已報價, 都不能編輯
        			Asserts.fail(ResultCode.STATUS_FAIL);
        		}
    		} else {
    			if (!status.equals("C")) {	//如果DB裡是等待回覆且user不為服務中心, 只要傳來要改的不是取消, 都不能編輯
        			Asserts.fail(ResultCode.STATUS_FAIL);
        		}
    		}
    	} else if (inquiriesDB.getInquiryStatus().equals("R")) {	//R為最終, 不可能再改變
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	} else if (inquiriesDB.getInquiryStatus().equals("C")) {	//C為最終, 不可能再改變
    		Asserts.fail(ResultCode.STATUS_FAIL);
    	}
    	Inquiries inquiries = new Inquiries();
    	inquiries.setInquiryId(id);
    	inquiries.setUpdateDatetime(new Date());
    	inquiries.setUpdateUserId(userid);
    	inquiries.setInquiryStatus(status);
        int count = inquiriesMapper.updateByPrimaryKeySelective(inquiries);
        // 確認是否要寄信
        if (status.equals("W")) {
        	count += this.sendMailForWaiting(inquiriesDB);
        }
        return count;
    }
    
    @Override
    public int delete(String id) {
    	Inquiries inquiries = this.isInquiriesStatusCanDelete(id);	// 後端再次確認報價單是否存在,以及報價單狀態是否為草稿
    	int count = inquiriesMapper.deleteByPrimaryKey(id);
    	File file = new File(inquiries.getAttachment());
    	File folder = file.getParentFile();
    	FileSystemUtils.deleteRecursively(folder);
        return count;
    }
    
    @Override
	public int upload(String inquiryId, MultipartFile uploadFile, HttpServletRequest req) {
    	this.isInquiriesExist(inquiryId);	//判斷詢價單是否存在
    	String path = "upload-files" + this.separator + inquiryId + this.separator;
    	String folderPath = fileUploadRootPath + path;
		
		String oldName = uploadFile.getOriginalFilename();
		String newName = UUID.randomUUID().toString() + "-" + oldName;
		String filePath = null;
		int count = 0;
		try {
			File folder = new File(folderPath);
			if (!folder.isDirectory()) {
				folder.mkdirs();
			} else {
				FileUtils.cleanDirectory(folder);
				if (this.setInquiriesAttachFile(inquiryId, null) <= 0) {
					Asserts.fail(ResultCode.INQUIRIES_NOT_EXIST);
				}
			}
			File file = new File(folder, newName);
			uploadFile.transferTo(file);
			filePath = file.getAbsolutePath();
			count = this.setInquiriesAttachFile(inquiryId, filePath);
			if (count <= 0) {
				Asserts.fail(ResultCode.INQUIRIES_NOT_EXIST);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Asserts.fail(ResultCode.FILE_UPLOAD_IO_FAIL);
		}
		return count;
	}
    
    @Override
	public Resource download(String inquiryId) {
    	Inquiries inquiriesDB = this.isInquiriesExist(inquiryId);	//判斷詢價單是否存在
    	Resource resource = null;
    	if (inquiriesDB.getAttachment() != null) {
    		File file = new File(inquiriesDB.getAttachment());
    		if (!file.exists()) {
    			this.setInquiriesAttachFile(inquiryId, null);
    			Asserts.fail(ResultCode.FILE_NOT_FOUND);
    		}
    		try {
    			byte[] templateContent = FileCopyUtils.copyToByteArray(file);
    			resource = new ByteArrayResource(templateContent);
    		} catch (IOException e) {
    			e.printStackTrace();
    			Asserts.fail(ResultCode.FILE_UPLOAD_IO_FAIL);
    		}
    	} else {
    		Asserts.fail(ResultCode.FILE_NOT_FOUND);
    	}
    	return resource;
    }
    
    private Inquiries isInquiriesExist(String inquiryId) {
    	Inquiries inquiriesDB = inquiriesMapper.selectByPrimaryKey(inquiryId);
    	if (inquiriesDB == null || inquiriesDB.getFlag() == 0) {
    		Asserts.fail(ResultCode.INQUIRIES_NOT_EXIST);
    	}
    	return inquiriesDB;
    }
    
    private Inquiries isInquiriesStatusCanDelete(String inquiryId) {
    	// 後端再次確認報價單存在,以及狀態只能為草稿
    	InquiriesExample example = new InquiriesExample();
        InquiriesExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andInquiryStatusEqualTo("D");
        criteria.andInquiryIdEqualTo(inquiryId);
        List<Inquiries> list = inquiriesMapper.selectByExample(example);
        if (list.size() <= 0) {
        	Asserts.fail(ResultCode.STATUS_FAIL);
        }
        return list.get(0);
    }
    
    private int sendMailForWaiting(Inquiries inquiries) {
    	SimpleDateFormat sdfReqDate = new SimpleDateFormat("yyyy-MM-dd");
    	//取得用戶及群組相關資訊
		UmsUser user = userMapper.selectByPrimaryKey(inquiries.getInquiryUserId());
		String name = user.getUsername();
		Long id = user.getId();
		if (user.getGroupId() != null) {
			UmsGroup group = groupMapper.selectByPrimaryKey(user.getGroupId());
			name = group.getName();
			id = group.getId();
		}
    	
		String category = "inquiryWaitingStatus";
		String subject = "D-casting 服務中心-用戶 "+name+" 的詢價單("+inquiries.getInquiryId()+")等待回覆中";
		String content = "用戶名稱:"+name+", 商品名稱:"+inquiries.getProductName()+
				", 需求日期:"+sdfReqDate.format(inquiries.getRequirementDate());
		String contentType = "T";
		String from = user.getEmail();
		String to = systemMailRecipient;
		// 寄信
    	Mailer mailer = tool.generateMailer(category, subject, content, contentType, from, to, id, name);
        int count = mailMapper.insertSelective(mailer);
    	return count;
    }
    
    private int setInquiriesAttachFile(String inquiryId, String filePath) {
    	Inquiries inquiries = new Inquiries();
		inquiries.setInquiryId(inquiryId);
		inquiries.setAttachment(filePath);
		return inquiriesDao.setAttachFilePath(inquiryId, filePath);
    }
}
