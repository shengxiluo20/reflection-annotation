package com.chi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PicUrl {
    /**
     * 是否为私有地址
     * @return
     */
    boolean isPrivate() default false;
}
