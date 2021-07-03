package com.zealot.dcasting.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Quotations implements Serializable {
    private String quotationId;

    private String inquiryId;

    private String inquiryName;

    private Long amount;

    private Date estimatedDeliveryDate;

    private Date estimatedArrivalDate;

    private Date validDate;

    private String quotationStatus;

    private Long inquiryUserId;

    private Long inquiryGroupId;

    private Long supplierId;

    private String remark;

    private Long createUserId;

    private Date createDatetime;

    private Long updateUserId;

    private Date updateDatetime;

    private Integer flag;

    private static final long serialVersionUID = 1L;

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Date getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(Date estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getQuotationStatus() {
        return quotationStatus;
    }

    public void setQuotationStatus(String quotationStatus) {
        this.quotationStatus = quotationStatus;
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
        sb.append(", quotationId=").append(quotationId);
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", inquiryName=").append(inquiryName);
        sb.append(", amount=").append(amount);
        sb.append(", estimatedDeliveryDate=").append(estimatedDeliveryDate);
        sb.append(", estimatedArrivalDate=").append(estimatedArrivalDate);
        sb.append(", validDate=").append(validDate);
        sb.append(", quotationStatus=").append(quotationStatus);
        sb.append(", inquiryUserId=").append(inquiryUserId);
        sb.append(", inquiryGroupId=").append(inquiryGroupId);
        sb.append(", supplierId=").append(supplierId);
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