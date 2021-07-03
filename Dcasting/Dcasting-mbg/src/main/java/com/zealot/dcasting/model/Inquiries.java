package com.zealot.dcasting.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Inquiries implements Serializable {
    private String inquiryId;

    private Long inquiryUserId;

    private Long inquiryGroupId;

    private String productName;

    private Integer productQuantity;

    private String serviceCategory;

    private String materialType;

    private String payment;

    private Date requirementDate;

    private String shippingAddress;

    private String shipment;

    private String packing;

    private String inquiryStatus;

    private String attachment;

    private String remark;

    private Long createUserId;

    private Date createDatetime;

    private Long updateUserId;

    private Date updateDatetime;

    private Integer flag;

    private static final long serialVersionUID = 1L;

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getRequirementDate() {
        return requirementDate;
    }

    public void setRequirementDate(Date requirementDate) {
        this.requirementDate = requirementDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", inquiryUserId=").append(inquiryUserId);
        sb.append(", inquiryGroupId=").append(inquiryGroupId);
        sb.append(", productName=").append(productName);
        sb.append(", productQuantity=").append(productQuantity);
        sb.append(", serviceCategory=").append(serviceCategory);
        sb.append(", materialType=").append(materialType);
        sb.append(", payment=").append(payment);
        sb.append(", requirementDate=").append(requirementDate);
        sb.append(", shippingAddress=").append(shippingAddress);
        sb.append(", shipment=").append(shipment);
        sb.append(", packing=").append(packing);
        sb.append(", inquiryStatus=").append(inquiryStatus);
        sb.append(", attachment=").append(attachment);
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