package com.zealot.dcasting.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SaleOrderDetails implements Serializable {
    private Long id;

    private String orderId;

    private String itemNumber;

    private String itemCategory;

    private String itemCaption;

    private Integer unitPrice;

    private Integer itemQuantity;

    private Integer itemSubtotal;

    private Long itemSupplierId;

    private Long itemSupplierGroupId;

    private String remark;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemCaption() {
        return itemCaption;
    }

    public void setItemCaption(String itemCaption) {
        this.itemCaption = itemCaption;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Integer getItemSubtotal() {
        return itemSubtotal;
    }

    public void setItemSubtotal(Integer itemSubtotal) {
        this.itemSubtotal = itemSubtotal;
    }

    public Long getItemSupplierId() {
        return itemSupplierId;
    }

    public void setItemSupplierId(Long itemSupplierId) {
        this.itemSupplierId = itemSupplierId;
    }

    public Long getItemSupplierGroupId() {
        return itemSupplierGroupId;
    }

    public void setItemSupplierGroupId(Long itemSupplierGroupId) {
        this.itemSupplierGroupId = itemSupplierGroupId;
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
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", itemNumber=").append(itemNumber);
        sb.append(", itemCategory=").append(itemCategory);
        sb.append(", itemCaption=").append(itemCaption);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", itemQuantity=").append(itemQuantity);
        sb.append(", itemSubtotal=").append(itemSubtotal);
        sb.append(", itemSupplierId=").append(itemSupplierId);
        sb.append(", itemSupplierGroupId=").append(itemSupplierGroupId);
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