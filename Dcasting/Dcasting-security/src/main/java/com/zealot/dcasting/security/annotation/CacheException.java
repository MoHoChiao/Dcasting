package com.zealot.dcasting.security.annotation;

import java.lang.annotation.*;

/**
 * 自定義註解，有該註解的緩存方法會拋出異常
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
