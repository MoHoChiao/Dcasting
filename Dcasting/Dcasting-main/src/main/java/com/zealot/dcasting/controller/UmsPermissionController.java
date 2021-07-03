package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsPermissionCategory;
import com.zealot.dcasting.security.component.DynamicSecurityMetadataSource;
import com.zealot.dcasting.service.UmsPermissionCategoryService;
import com.zealot.dcasting.service.UmsPermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 使用者權限管理
 * Created by LeoLiu on 2020/6/9.
 */
@Controller
@Api(tags = "UmsPermissionController", description = "使用者權限管理")
@RequestMapping("/permission")
public class UmsPermissionController {
    @Autowired
    private UmsPermissionService permissionService;
    @Autowired
    private UmsPermissionCategoryService permissionCategoryService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    
    @ApiOperation("添加權限")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsPermission permission) {
        int count = permissionService.create(permission);
        dynamicSecurityMetadataSource.clearDataSource();
        if(count > 0){
            return CommonResult.success(count);
        } else {
        	return CommonResult.failed("ApiResponseCode.Permission.AddPermissionFail");
        }
    }

    @ApiOperation("修改權限")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsPermission permission) {
        int count = permissionService.update(id, permission);
        dynamicSecurityMetadataSource.clearDataSource();
        if(count>0){
            return CommonResult.success(count);
        } else {
        	return CommonResult.failed("ApiResponseCode.Permission.EditPermissionFail");
        }
    }

    @ApiOperation("根據ID獲取權限詳情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsPermission> getItem(@PathVariable Long id) {
        UmsPermission umsPermission = permissionService.getItem(id);
        return CommonResult.success(umsPermission);
    }
    
    @ApiOperation("根據id刪除權限")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = permissionService.delete(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if(count>0){
            return CommonResult.success(count);
        } else {
        	return CommonResult.failed("ApiResponseCode.Permission.DeletePermissionFail");
        }
    }
    
    @ApiOperation("分頁模糊查詢權限")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsPermission>> list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String valueKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsPermission> permissionList = permissionService.list(categoryId,nameKeyword, valueKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(permissionList));
    }

    @ApiOperation("獲取所有權限列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> listAll() {
        List<UmsPermission> permissionList = permissionService.listAll();
        return CommonResult.success(permissionList);
    }
    
    @ApiOperation("獲取使用者所有權限（包括+-權限）")
    @RequestMapping(value = "/listByUserId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionListByUserId(@PathVariable Long userId) {
        List<UmsPermission> permissionList = permissionService.getPermissionListByUserId(userId);
        return CommonResult.success(permissionList);
    }
    
    @ApiOperation("獲取相應角色權限")
    @RequestMapping(value = "/listByRoleId/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionListByRoleId(@PathVariable Long roleId) {
        List<UmsPermission> permissionList = permissionService.getPermissionListByRoleId(roleId);
        return CommonResult.success(permissionList);
    }
    
    @ApiOperation("給使用者分配+-權限")
    @RequestMapping(value = "/allocToUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocPermissionToUser(@RequestParam(value = "userId", required = true) Long userId,
                                         @RequestParam(value = "permissionIds", required = true) List<Long> permissionIds) {
        int count = permissionService.allocPermissionToUser(userId, permissionIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Permission.AllocPermissionToUserFail");
    }
    
    @ApiOperation("給角色分配權限")
    @RequestMapping(value = "/allocToRole", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocPermissionToRole(@RequestParam(value = "roleId", required = true) Long roleId, 
    									@RequestParam(value = "permissionIds", required = true) List<Long> permissionIds) {
        int count = permissionService.allocPermissionToRole(roleId, permissionIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Permission.AllocPermissionToRoleFail");
    }
    
    @ApiOperation("查詢所有權限分類")
    @RequestMapping(value = "category/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermissionCategory>> listAllCategory() {
        List<UmsPermissionCategory> permissionList = permissionCategoryService.listAll();
        return CommonResult.success(permissionList);
    }

    @ApiOperation("添加權限分類")
    @RequestMapping(value = "category/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createCategory(@RequestBody UmsPermissionCategory umsPermissionCategory) {
        int count = permissionCategoryService.create(umsPermissionCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Permission.AddCategoryFail");
        }
    }

    @ApiOperation("修改權限分類")
    @RequestMapping(value = "category/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateCategory(@PathVariable Long id,
                               @RequestBody UmsPermissionCategory umsPermissionCategory) {
        int count = permissionCategoryService.update(id, umsPermissionCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Permission.EditCategoryFail");
        }
    }

    @ApiOperation("根據ID刪除權限分類")
    @RequestMapping(value = "category/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteCategory(@PathVariable Long id) {
        int count = permissionCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Permission.DeleteCategoryFail");
    }
}
