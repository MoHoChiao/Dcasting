package com.zealot.dcasting.service;

import com.zealot.dcasting.dto.UmsUserRet;
import com.zealot.dcasting.dto.UpdateUserPasswordParam;
import com.zealot.dcasting.model.UmsUser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 使用者Service
 * Created by LeoLiu on 2020/6/8.
 */
public interface UmsUserService {
    /**
     * 根據使用者帳號獲取使用者資料
     */
	UmsUser getUserByUsername(String username);

	/**
     * 申請重置密碼
     */
	@Transactional
	int applyResetPassword(String username, String mail);
	
    /**
     * 註冊功能
     */
	@Transactional
	UmsUser register(UmsUser umsUserParam);

	/**
     * 登錄功能
     * @param username 使用者帳號
     * @param password 密碼
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 舊的token
     */
    String refreshToken(String oldToken);

    /**
     * 根據使用者id獲取使用者資料
     */
    UmsUser getItem(Long id);

    /**
     * 根據關鍵字分頁查詢用戶
     */
    List<UmsUserRet> list(String keyword, String orderByClause, Integer pageSize, Integer pageNum);

    /**
     * 修改指定使用者信息
     */
    int update(Long id, UmsUser user);
    
    /**
     * 修改指定使用者信息
     */
    int updateStatus(UmsUser user);

    /**
     * 刪除指定使用者
     */
    @Transactional
    int delete(Date update_datetime, Long update_user_id, Long id, String username);

    /**
     * 修改密碼
     */
    int updatePassword(UpdateUserPasswordParam updatePasswordParam);

    /**
     * 獲取使用者信息(UserDetails)
     */
    UserDetails loadUserByUsername(String username);
}
