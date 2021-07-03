package com.zealot.dcasting.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsUserRet implements Serializable {
    @ApiModelProperty(value = "使用者ID")
    private Long id;

    @ApiModelProperty(value = "使用者帳號")
    private String username;

    @ApiModelProperty(value = "使用者密碼")
    private String password;

    @ApiModelProperty(value = "使用者郵件")
    private String email;

    @ApiModelProperty(value = "使用者暱稱")
    private String nickName;

    @ApiModelProperty(value = "使用者電話")
    private String phone;

    @ApiModelProperty(value = "帳號啟用狀態：0->禁用；1->啟用")
    private Integer status;

    @ApiModelProperty(value = "所屬群組")
    private Long groupId;
    
    @ApiModelProperty(value = "所屬群組名稱")
    private String name;

    @ApiModelProperty(value = "承作廠商標籤, Y:可顯示於承作廠商選取列表")
    private String isSupplier;

    @ApiModelProperty(value = "此帳號的登入時間")
    private Date loginTime;

    @ApiModelProperty(value = "記錄此筆紀錄的建立帳號")
    private Long createUserId;

    @ApiModelProperty(value = "記錄此筆紀錄的建立時間")
    private Date createDatetime;

    @ApiModelProperty(value = "記錄此筆紀錄的更新帳號")
    private Long updateUserId;

    @ApiModelProperty(value = "記錄此筆紀錄的更新時間")
    private Date updateDatetime;

    @ApiModelProperty(value = "記錄此筆紀錄, 0為刪除")
    private Short flag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(String isSupplier) {
        this.isSupplier = isSupplier;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", nickName=").append(nickName);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", groupId=").append(groupId);
        sb.append(", name=").append(name);
        sb.append(", isSupplier=").append(isSupplier);
        sb.append(", loginTime=").append(loginTime);
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