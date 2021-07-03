package com.zealot.dcasting.controller;

import com.zealot.dcasting.common.api.CommonPage;
import com.zealot.dcasting.common.api.CommonResult;
import com.zealot.dcasting.dto.OrdersQueryParam;
import com.zealot.dcasting.model.SaleOrderDetails;
import com.zealot.dcasting.model.SaleOrders;
import com.zealot.dcasting.service.OrderDetailsService;
import com.zealot.dcasting.service.OrdersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 銷售訂單管理
 * Created by LeoLiu on 2021/6/6.
 */
@Controller
@Api(tags = "OrdersController", description = "銷售訂單管理")
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    
    @ApiOperation("查詢所有銷售訂單")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SaleOrders>> listAll() {
        List<SaleOrders> ordersList = ordersService.listAll();
        return CommonResult.success(ordersList);
    }
    
    @ApiOperation("根據關鍵字-分頁獲取銷售訂單列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SaleOrders>> list(@RequestBody OrdersQueryParam queryParam) {
        List<SaleOrders> ordersList = ordersService.list(queryParam);
        return CommonResult.success(CommonPage.restPage(ordersList));
    }
    
    @ApiOperation("添加銷售訂單")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createOrders(@RequestBody SaleOrders orders) {
        int count = ordersService.create(orders);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Orders.AddOrdersFail");
        }
    }

    @ApiOperation("修改銷售訂單")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateOrders(@PathVariable String id,
                               @RequestBody SaleOrders orders) {
        int count = ordersService.update(id, orders);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.Orders.EditOrdersFail");
        }
    }

    @ApiOperation("根據ID改變銷售訂單狀態")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateOrdersStatus(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id,
           							@RequestParam(value = "status", required = true) String status) {
        int count = ordersService.updateStatus(userid, status, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Orders.UpdateOrdersStatusFail");
    }
    
    @ApiOperation("根據ID刪除銷售訂單")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteOrders(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) String id) {
    	Date updatetime = new Date();
        int count = ordersService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.Orders.DeleteOrdersFail");
    }
    
    @ApiOperation("查詢所有銷售訂單明細")
    @RequestMapping(value = "/listAllDetails", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SaleOrderDetails>> listAllDetails() {
        List<SaleOrderDetails> orderDetailsList = orderDetailsService.listAll();
        return CommonResult.success(orderDetailsList);
    }

    @ApiOperation("根據銷售訂單獲取銷售訂單明細列表")
    @RequestMapping(value = "/listDetails", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SaleOrderDetails>> listDetails(@RequestParam(value = "orderId", required = true) String orderId,
    												@RequestParam(value = "orderByClause", required = true) String orderByClause) {
        List<SaleOrderDetails> orderDetailsList = orderDetailsService.list(orderId, orderByClause);
        return CommonResult.success(orderDetailsList);
    }
    
    @ApiOperation("添加銷售訂單明細")
    @RequestMapping(value = "/createDetails", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createDetails(@RequestBody SaleOrderDetails details) {
        int count = orderDetailsService.create(details);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.OrderDetails.AddDetailsFail");
        }
    }

    @ApiOperation("修改銷售訂單明細")
    @RequestMapping(value = "/updateDetails/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDetails(@PathVariable Long id,
                               @RequestBody SaleOrderDetails umsDetails) {
        int count = orderDetailsService.update(id, umsDetails);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("ApiResponseCode.OrderDetails.EditDetailsFail");
        }
    }

    @ApiOperation("根據ID刪除銷售訂單明細")
    @RequestMapping(value = "/deleteDetails", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteDetails(@RequestParam(value = "userid", required = true) Long userid,
           							@RequestParam(value = "id", required = true) Long id) {
    	Date updatetime = new Date();
        int count = orderDetailsService.delete(updatetime, userid, id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("ApiResponseCode.OrderDetails.DeleteDetailsFail");
    }
}
