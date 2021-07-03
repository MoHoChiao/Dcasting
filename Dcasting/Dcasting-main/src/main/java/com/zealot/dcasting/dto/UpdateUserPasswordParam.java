package com.zealot.dcasting.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 修改使用者密碼參數
 * Created by LeoLiu on 2020/6/7.
 */
@Getter
@Setter
public class UpdateUserPasswordParam {
	@ApiModelProperty(value = "使用者ID", required = true)
    private Long id;
    @ApiModelProperty(value = "使用者帳號", required = true)
    private String username;
    @ApiModelProperty(value = "舊密碼", required = true)
    private String oldPassword;
    @ApiModelProperty(value = "新密碼", required = true)
    private String newPassword;
}
