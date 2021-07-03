package com.zealot.dcasting.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 使用者登錄參數
 * Created by LeoLiu on 2020/6/7.
 */
public class UmsUserLoginParam {
    @ApiModelProperty(value = "使用者帳號", required = true)
    private String username;
    @ApiModelProperty(value = "使用者密碼", required = true)
    private String password;

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
}
