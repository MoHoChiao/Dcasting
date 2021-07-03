package com.zealot.dcasting.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 修改使用者密碼參數
 * Created by LeoLiu on 2021/5/27.
 */
@Getter
@Setter
public class UpdateInquiriesStatusParam {
	@ApiModelProperty(value = "編輯者ID", required = true)
    private Long updateUserId;
    @ApiModelProperty(value = "編輯時間", required = true)
    private Date updateDatetime;
    @ApiModelProperty(value = "詢價單狀態", required = true)
    private String inquiryStatus;
}
