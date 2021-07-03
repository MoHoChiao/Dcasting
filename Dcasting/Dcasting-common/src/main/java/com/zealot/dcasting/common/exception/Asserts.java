package com.zealot.dcasting.common.exception;

import com.zealot.dcasting.common.api.IErrorCode;

/**
 * 斷言處理類，用於拋出各種API異常
 * Created by LeoLiu on 2020/6/4.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }
    
    public static void fail(String message, Throwable cause) {
        throw new ApiException(message, cause);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
