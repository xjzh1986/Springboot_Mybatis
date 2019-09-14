package com.example.interceptor;

import java.lang.annotation.*;

/**
 * Created by xjz on 2019/9/13.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiredPermission {
    String value();
}