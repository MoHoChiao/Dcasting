package com.zealot.dcasting.common.api;

/**
 * 封裝API的錯誤碼
 * Created by LeoLiu on 2020/6/4.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
