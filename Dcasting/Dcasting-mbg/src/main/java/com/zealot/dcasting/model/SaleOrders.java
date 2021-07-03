package com.zealot.dcasting.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SaleOrders implements Serializable {
    private String orderId;

    private String sapId;

    private String deliveryId;

    private String inquiryId;

    private String inquiryName;

    private String quotationId;

    private Long amount;

    private Integer receivedDeposit;

    private Date estimatedDeliveryDate;

    private Date actualDeliveryDate;

    private Date estimatedArrivalDate;

    private Date actualArrivalDate;

    private String orderStatus;

    private Long inquiryUserId;

    private Long inquiryGroupId;

    private Long supplierId;

    private Long supplierGroupId;

    private String remark;

    private Long createUserId;

    private Date createDatetime;

    private Long updateUserId;

    private Date updateDatetime;

    private Integer flag;

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSapId() {
        return sapId;
    }

    public void setSapId(String sapId) {
        this.sapId = sapId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getInquiryName() {
        return inquiryName;
    }

    public void setInquiryName(String inquiryName) {
        this.inquiryName = inquiryName;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getReceivedDeposit() {
        return receivedDeposit;
    }

    public void setReceivedDeposit(Integer receivedDeposit) {
        this.receivedDeposit = receivedDeposit;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Date getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public void setActualDeliveryDate(Date actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public Date getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(Date estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public Date getActualArrivalDate() {
        return actualArrivalDate;
    }

    public void setActualArrivalDate(Date actualArrivalDate) {
        this.actualArrivalDate = actualArrivalDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getInquiryUserId() {
        return inquiryUserId;
    }

    public void setInquiryUserId(Long inquiryUserId) {
        this.inquiryUserId = inquiryUserId;
    }

    public Long getInquiryGroupId() {
        return inquiryGroupId;
    }

    public void setInquiryGroupId(Long inquiryGroupId) {
        this.inquiryGroupId = inquiryGroupId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierGroupId() {
        return supplierGroupId;
    }

    public void setSupplierGroupId(Long supplierGroupId) {
        this.supplierGroupId = supplierGroupId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", sapId=").append(sapId);
        sb.append(", deliveryId=").append(deliveryId);
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", inquiryName=").append(inquiryName);
        sb.append(", quotationId=").append(quotationId);
        sb.append(", amount=").append(amount);
        sb.append(", receivedDeposit=").append(receivedDeposit);
        sb.append(", estimatedDeliveryDate=").append(estimatedDeliveryDate);
        sb.append(", actualDeliveryDate=").append(actualDeliveryDate);
        sb.append(", estimatedArrivalDate=").append(estimatedArrivalDate);
        sb.append(", actualArrivalDate=").append(actualArrivalDate);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", inquiryUserId=").append(inquiryUserId);
        sb.append(", inquiryGroupId=").append(inquiryGroupId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierGroupId=").append(supplierGroupId);
        sb.append(", remark=").append(remark);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDatetime=").append(createDatetime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateDatetime=").append(updateDatetime);
        sb.append(", flag=").append(flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}