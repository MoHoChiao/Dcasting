package com.zealot.dcasting.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.zealot.dcasting.bo.CustomizedUserDetails;
import com.zealot.dcasting.common.api.ResultCode;
import com.zealot.dcasting.common.exception.Asserts;
import com.zealot.dcasting.dao.UmsUserDao;
import com.zealot.dcasting.dto.UmsUserExampleRet;
import com.zealot.dcasting.dto.UmsUserRet;
import com.zealot.dcasting.dto.UpdateUserPasswordParam;
import com.zealot.dcasting.mapper.InquiriesMapper;
import com.zealot.dcasting.mapper.MailerMapper;
import com.zealot.dcasting.mapper.ProjectsMapper;
import com.zealot.dcasting.mapper.QuotationsMapper;
import com.zealot.dcasting.mapper.SaleOrdersMapper;
import com.zealot.dcasting.mapper.UmsUserLoginLogMapper;
import com.zealot.dcasting.mapper.UmsUserMapper;
import com.zealot.dcasting.mapper.UmsUserPermissionRelationMapper;
import com.zealot.dcasting.mapper.UmsUserRoleRelationMapper;
import com.zealot.dcasting.model.*;
import com.zealot.dcasting.util.Tool;
import com.zealot.dcasting.security.util.JwtTokenUtil;
import com.zealot.dcasting.service.UmsPermissionService;
import com.zealot.dcasting.service.UmsUserCacheService;
import com.zealot.dcasting.service.UmsUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UmsUserService實作
 * Created by LeoLiu on 2020/6/8.
 */
@Service
public class UmsUserServiceImpl implements UmsUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsUserServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private Tool tool;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private UmsUserDao userDao;
    @Autowired
    private UmsUserRoleRelationMapper userRoleRelationMapper;
    @Autowired
    private UmsUserPermissionRelationMapper userPermissionRelationMapper;
    @Autowired
    private UmsUserLoginLogMapper loginLogMapper;
    @Autowired
    private MailerMapper mailMapper;
    @Autowired
    private InquiriesMapper inquiriesMapper;
    @Autowired
    private QuotationsMapper quotationsMapper;
    @Autowired
    private SaleOrdersMapper ordersMapper;
    @Autowired
    private ProjectsMapper projectsMapper;
    @Autowired
    private UmsPermissionService permissionService;
    @Autowired
    private UmsUserCacheService userCacheService;
    @Value("${systemMailSender}")
    private String systemMailSender;

    @Override
    public UmsUser getUserByUsername(String username) {
        UmsUser user = userCacheService.getUser(username);
        if(user != null) return user;
        UmsUserExample example = new UmsUserExample();
        UmsUserExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andUsernameEqualTo(username);
        List<UmsUser> userList = userMapper.selectByExample(example);
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
            if(user.getStatus() == 0){	// 檢查帳號是否被鎖定
            	Asserts.fail(ResultCode.USER_LOCKED);
            }
            userCacheService.setUser(user);
            return user;
        }
        return null;
    }

    @Override
    public UmsUser register(UmsUser umsUser) {
        //umsUser.setStatus(1);
        umsUser.setFlag(1);
        //查詢是否有相同帳號的使用者
        UmsUserExample example = new UmsUserExample();
        UmsUserExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andUsernameEqualTo(umsUser.getUsername());
        long count = userMapper.countByExample(example);
        if (count > 0L) {
        	Asserts.fail(ResultCode.ACCOUNT_EXIST);
        }
        //將密碼進行加密操作
        String password = tool.generateRandomPassword(10, 48, 122);
        String encodePassword = passwordEncoder.encode(password);
        umsUser.setPassword(encodePassword);
        userMapper.insertSelective(umsUser);
        
        Mailer mailer = tool.generateMailer("register", "D-casting 服務中心-會員帳號申請成功",
        		"您已申請成功, 帳號開通可能需要數十分鐘至數小時不等, 請您耐心等候, 同時!歡迎您加入D-Casting!,  帳號:"+ umsUser.getUsername() + ", 密碼:" + password,
        		"T", systemMailSender, umsUser.getEmail(), umsUser.getId(), umsUser.getUsername());
        mailMapper.insertSelective(mailer);
        
        return umsUser;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密碼需要客戶端加密後傳遞
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("使用者的密碼錯誤");
            }
            
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登錄異常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 添加登錄記錄
     * @param username 使用者帳號
     */
    private void insertLoginLog(String username) {
        UmsUser user = getUserByUsername(username);
        if(user==null) return;
        UmsUserLoginLog loginLog = new UmsUserLoginLog();
        loginLog.setUserId(user.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根據使用者帳號修改登錄時間
     */
    private void updateLoginTimeByUsername(String username) {
        UmsUser record = new UmsUser();
        record.setLoginTime(new Date());
        UmsUserExample example = new UmsUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        userMapper.updateByExampleSelective(record, example);
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public UmsUser getItem(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UmsUserRet> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsUserExampleRet example = new UmsUserExampleRet();
        UmsUserExampleRet.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        if (!StringUtils.isEmpty(keyword)) {
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("username", keyword);
        	map.put("email", keyword);
        	map.put("nick_name", keyword);
        	map.put("phone", keyword);
        	map.put("name", keyword);
        	criteria.multiColumnOrClause(map);
        }
        if (!StringUtils.isEmpty(orderByClause)) {
        	example.setOrderByClause(orderByClause);
        }
        
        return userDao.leftJoinSelectByExample(example);
    }

    @Override
    public int update(Long id, UmsUser umsUser) {
        umsUser.setId(id);
        UmsUser rawUser = userMapper.selectByPrimaryKey(id);
        // 檢查原帳號是否相同
        if(!rawUser.getUsername().equals(umsUser.getUsername())){
        	//與原帳號不相同, 查詢是否有相同帳號的使用者
            UmsUserExample example = new UmsUserExample();
            UmsUserExample.Criteria criteria = example.createCriteria();
            criteria.andFlagNotEqualTo(0);
            criteria.andUsernameEqualTo(umsUser.getUsername());
            long count = userMapper.countByExample(example);
            if (count > 0L) {
            	Asserts.fail(ResultCode.ACCOUNT_EXIST);
            }
        }
        
        int count = userMapper.updateByPrimaryKey(umsUser);
        userCacheService.delUser(umsUser.getUsername());
        return count;
    }
    
    @Override
    public int updateStatus(UmsUser user) {
    	user.setUpdateDatetime(new Date());
        int count = userMapper.updateByPrimaryKeySelective(user);
        userCacheService.delUser(user.getUsername());
        userCacheService.delPermissionList(user.getId());
        return count;
    }

    @Override
    public int delete(Date update_datetime, Long update_user_id, Long id, String username) {
    	// 判斷此用戶在詢價單上有沒有非最終狀態的單子(草稿或等待回覆)
    	InquiriesExample inquiriesExample = new InquiriesExample();
    	InquiriesExample.Criteria inquiriesCriteria = inquiriesExample.createCriteria();
    	inquiriesCriteria.andFlagNotEqualTo(0);
        List<String> inquiriesStatus = new ArrayList<String>();
        inquiriesStatus.add("D");
        inquiriesStatus.add("W");
        inquiriesCriteria.andInquiryStatusIn(inquiriesStatus);
        inquiriesCriteria.andInquiryUserIdEqualTo(id);
        Long selectInquiriesCount = inquiriesMapper.countByExample(inquiriesExample);
        if (selectInquiriesCount > 0L) {
        	Asserts.fail(ResultCode.USER_INQUIRIES_PROCESSING);
        }
        // 判斷此用戶在報價單上有沒有非最終狀態的單子(草稿或等待回覆)
        QuotationsExample quotationsExample = new QuotationsExample();
        QuotationsExample.Criteria quotationsCriteria = quotationsExample.createCriteria();
        quotationsCriteria.andFlagNotEqualTo(0);
        List<String> quotationsStatus = new ArrayList<String>();
        quotationsStatus.add("D");
        quotationsStatus.add("W");
        quotationsCriteria.andQuotationStatusIn(quotationsStatus);
        quotationsCriteria.andInquiryUserIdEqualTo(id);
        Long selectQuotationsCount = quotationsMapper.countByExample(quotationsExample);
        if (selectQuotationsCount > 0L) {
        	Asserts.fail(ResultCode.USER_QUOTATIONS_PROCESSING);
        }
        // 判斷此用戶在銷售訂單上有沒有非最終狀態的單子(準備中或製作中或已製作完成)
        SaleOrdersExample ordersExample = new SaleOrdersExample();
        SaleOrdersExample.Criteria ordersCriteria = ordersExample.createCriteria();
        ordersCriteria.andFlagNotEqualTo(0);
        List<String> ordersStatus = new ArrayList<String>();
        ordersStatus.add("W");
        ordersStatus.add("P");
        ordersStatus.add("E");
        ordersCriteria.andOrderStatusIn(ordersStatus);
        ordersCriteria.andInquiryUserIdEqualTo(id);
        Long selectOrdersCount = ordersMapper.countByExample(ordersExample);
        if (selectOrdersCount > 0L) {
        	Asserts.fail(ResultCode.USER_ORDERS_PROCESSING);
        }
        // 判斷此用戶在專案上有沒有非最終狀態的單子(等待啟動或執行中)
        ProjectsExample projectsExample = new ProjectsExample();
        ProjectsExample.Criteria projectsCriteria = projectsExample.createCriteria();
        projectsCriteria.andFlagNotEqualTo(0);
        projectsCriteria.andProjectStatusEqualTo(0);
        projectsCriteria.andSupplierIdEqualTo(id);
        Long selectProjectsCount = projectsMapper.countByExample(projectsExample);
        if (selectProjectsCount > 0L) {
        	Asserts.fail(ResultCode.USER_PROJECTS_PROCESSING);
        }
    	
        // 刪除user_role關係
    	UmsUserRoleRelationExample urrExample = new UmsUserRoleRelationExample();
    	urrExample.createCriteria().andUserIdEqualTo(id);
    	userRoleRelationMapper.deleteByExample(urrExample);
    	// 刪除user_permission關係
    	UmsUserPermissionRelationExample uprExample = new UmsUserPermissionRelationExample();
    	uprExample.createCriteria().andUserIdEqualTo(id);
    	userPermissionRelationMapper.deleteByExample(uprExample);
    	// 刪除redis中的permissionList
        userCacheService.delPermissionList(id);
        
        // 刪除user
        int count = userDao.deleteById(update_datetime, update_user_id, id);
        // 刪除redis中的user
        userCacheService.delUser(username);
        return count;
    }

    @Override
    public int updatePassword(UpdateUserPasswordParam param) {
        UmsUserExample example = new UmsUserExample();
        UmsUserExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andUsernameEqualTo(param.getUsername());
        List<UmsUser> userList = userMapper.selectByExample(example);
        if(CollUtil.isEmpty(userList)){
        	Asserts.fail(ResultCode.ACCOUNT_NOT_EXIST);
        }
        UmsUser umsUser = userList.get(0);
        if(!passwordEncoder.matches(param.getOldPassword(), umsUser.getPassword())){
        	Asserts.fail(ResultCode.OLD_PASSWORD_FAILED);
        }
        umsUser.setPassword(passwordEncoder.encode(param.getNewPassword()));
        umsUser.setUpdateDatetime(new Date());
        umsUser.setUpdateUserId(param.getId());
        int count = userMapper.updateByPrimaryKey(umsUser);
        userCacheService.delUser(umsUser.getUsername());
        return count;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //獲取使用者信息
        UmsUser user = getUserByUsername(username);
        if (user != null) {
            List<UmsPermission> permissionList = permissionService.getPermissionListByUserId(user.getId());
            return new CustomizedUserDetails(user, permissionList);
        }
        throw new UsernameNotFoundException("使用者帳號不存在");
    }

	@Override
	public int applyResetPassword(String username, String mail) {
		UmsUserExample example = new UmsUserExample();
        UmsUserExample.Criteria criteria = example.createCriteria();
        criteria.andFlagNotEqualTo(0);
        criteria.andUsernameEqualTo(username);
        criteria.andEmailEqualTo(mail);
        List<UmsUser> userList = userMapper.selectByExample(example);
        if(CollUtil.isEmpty(userList)){
        	Asserts.fail(ResultCode.ACCOUNT_OR_EMAIL_NOT_EXIST);
        }
        
        UmsUser umsUser = userList.get(0);
        String newPassword = tool.generateRandomPassword(10, 48, 122);
        umsUser.setPassword(passwordEncoder.encode(newPassword));
        umsUser.setUpdateDatetime(new Date());
        int count = userMapper.updateByPrimaryKey(umsUser);
        
        Mailer mailer = tool.generateMailer("applyResetPassword", "D-casting 服務中心-密碼重置成功", "重置密碼:"+newPassword,
        		"T", systemMailSender, mail, umsUser.getId(), username);
        count += mailMapper.insertSelective(mailer);
        
        userCacheService.delUser(username);
        return count;
	}
}
