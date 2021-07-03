package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.UmsUserLoginParam;
import com.zealot.dcasting.dto.UmsUserRet;
import com.zealot.dcasting.dto.UpdateUserPasswordParam;
import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsUser;
import com.zealot.dcasting.service.UmsPermissionService;
import com.zealot.dcasting.service.UmsUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用者管理Controller
 * Created by LeoLiu on 2020/6/9.
 */
@Controller
@Api(tags = "UmsUserController", description = "使用者管理")
@RequestMapping("/user")
public class UmsUserController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsUserService userService;
    @Autowired
    private UmsPermissionService permissionService;

    @ApiOperation("重置密碼申請")
    @RequestMapping(value = "/applyResetPassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult applyResetPassword(@RequestParam(value = "username", required = true) String username,
    												@RequestParam(value = "mail", required = true) String mail) {
        int count = userService.applyResetPassword(username, mail);
        if (count == 2) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.User.ApplyResetPasswordFail");
    }
    
    @ApiOperation(value = "使用者註冊")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsUser> register(@RequestBody UmsUser umsUser) {
        UmsUser umsUserRet = userService.register(umsUser);
        return CommonResult.success(umsUserRet);
    }

    @ApiOperation(value = "登錄以後返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsUserLoginParam umsUserLoginParam, BindingResult result) {
        String token = userService.login(umsUserLoginParam.getUsername(), umsUserLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("ApiResponseCode.User.ValidateFail");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = userService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("ApiResponseCode.User.TokenExpired");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "獲取當前登錄使用者信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getUserInfo(Principal principal) {
        if(principal == null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsUser umsUser = userService.getUserByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("userid", umsUser.getId());
        data.put("username", umsUser.getUsername());
        data.put("roles", new String[]{"TEST"});
        List<UmsPermission> permissionList = permissionService.getPermissionListByUserId(umsUser.getId());
        UmsPermission basic_usertype = new UmsPermission();
        basic_usertype.setName(umsUser.getIsSupplier());
        permissionList.add(basic_usertype);
        data.put("permissions", permissionList);
        data.put("groupid", umsUser.getGroupId());
        data.put("usertype", umsUser.getIsSupplier());
        return CommonResult.success(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("根據關鍵字-分頁獲取用戶列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsUserRet>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   	@RequestParam(value = "orderByClause", required = false) String orderByClause,
                                                   	@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   	@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsUserRet> userList = userService.list(keyword, orderByClause, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }

    @ApiOperation("根據使用者ID獲取指定使用者信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsUser> getItem(@PathVariable Long id) {
        UmsUser user = userService.getItem(id);
        return CommonResult.success(user);
    }

    @ApiOperation("修改指定使用者信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsUser umsUser) {
        int count = userService.update(id, umsUser);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.User.EditUserFail");
    }

    @ApiOperation("修改指定使用者密碼")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody UpdateUserPasswordParam updatePasswordParam) {
        int count = userService.updatePassword(updatePasswordParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.User.EditPasswordFail");
    }

    @ApiOperation("刪除指定使用者信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam(value = "userid", required = true) Long userid,
								@RequestParam(value = "id", required = true) Long id,
								@RequestParam(value = "username", required = true) String username) {
    	Date updatetime = new Date();
        int count = userService.delete(updatetime, userid, id, username);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.User.DeleteUserFail");
    }

    @ApiOperation("修改使用者帳號狀態")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status", required = true) 
    									Integer status, @RequestParam(value = "username", required = true) String username) {
        UmsUser umsUser = new UmsUser();
        umsUser.setId(id);
        umsUser.setStatus(status);
        umsUser.setUsername(username);
        int count = userService.updateStatus(umsUser);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.EditStatusFailed");
    }
}
