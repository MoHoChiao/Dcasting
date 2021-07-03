package com.zealot.dcasting.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ProjectDetails implements Serializable {
    private Long id;

    private String projectId;

    private String inquiryId;

    private String inquiryName;

    private String detailProgress;

    private String detailNumber;

    private String detailCategory;

    private String detailCaption;

    private String detailDescription;

    private Long detailSupplierId;

    private Long detailSupplierGroupId;

    private Long createUserId;

    private Date createDatetime;

    private Long updateUserId;

    private Date updateDatetime;

    private Integer flag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    public String getDetailProgress() {
        return detailProgress;
    }

    public void setDetailProgress(String detailProgress) {
        this.detailProgress = detailProgress;
    }

    public String getDetailNumber() {
        return detailNumber;
    }

    public void setDetailNumber(String detailNumber) {
        this.detailNumber = detailNumber;
    }

    public String getDetailCategory() {
        return detailCategory;
    }

    public void setDetailCategory(String detailCategory) {
        this.detailCategory = detailCategory;
    }

    public String getDetailCaption() {
        return detailCaption;
    }

    public void setDetailCaption(String detailCaption) {
        this.detailCaption = detailCaption;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public Long getDetailSupplierId() {
        return detailSupplierId;
    }

    public void setDetailSupplierId(Long detailSupplierId) {
        this.detailSupplierId = detailSupplierId;
    }

    public Long getDetailSupplierGroupId() {
        return detailSupplierGroupId;
    }

    public void setDetailSupplierGroupId(Long detailSupplierGroupId) {
        this.detailSupplierGroupId = detailSupplierGroupId;
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
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", inquiryName=").append(inquiryName);
        sb.append(", detailProgress=").append(detailProgress);
        sb.append(", detailNumber=").append(detailNumber);
        sb.append(", detailCategory=").append(detailCategory);
        sb.append(", detailCaption=").append(detailCaption);
        sb.append(", detailDescription=").append(detailDescription);
        sb.append(", detailSupplierId=").append(detailSupplierId);
        sb.append(", detailSupplierGroupId=").append(detailSupplierGroupId);
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