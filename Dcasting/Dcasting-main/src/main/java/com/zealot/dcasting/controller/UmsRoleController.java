package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.model.*;
import com.zealot.dcasting.service.UmsRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 使用者角色管理Controller
 * Created by LeoLiu on 2020/6/9.
 */
@Controller
@Api(tags = "UmsRoleController", description = "使用者角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole umsRole) {
        int count = roleService.create(umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Role.AddRoleFail");
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsRole umsRole) {
        int count = roleService.update(id, umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Role.EditRoleFail");
    }

    @ApiOperation("批量刪除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam(value = "userid", required = true) Long userid,
    							@RequestParam(value = "ids", required = true) List<Long> ids) {
    	Date updatetime = new Date();
        int count = roleService.delete(updatetime, userid, ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Role.DeleteRoleFail");
    }

    @ApiOperation("獲取指定使用者的角色")
    @RequestMapping(value = "/listByUserId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long userId) {
        List<UmsRole> roleList = roleService.getRoleListByUserId(userId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("獲取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.listAll();
        return CommonResult.success(roleList);
    }

    @ApiOperation("根據角色名稱或描述-分頁獲取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
    												@RequestParam(value = "orderByClause", required = false) String orderByClause,
    												@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
    												@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsRole> roleList = roleService.list(keyword, orderByClause, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色狀態")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status", required = true) Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setId(id);
        umsRole.setStatus(status);
        int count = roleService.updateStatus(umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.EditRoleStatusFail");
    }

    @ApiOperation("給使用者分配角色")
    @RequestMapping(value = "/alloc", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocRole(@RequestParam(value = "userId", required = true) Long userId,
                                   @RequestParam(value = "roleIds", required = true) List<Long> roleIds) {
        int count = roleService.allocRole(userId, roleIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Role.AllocRoleToUserFail");
    }
}
