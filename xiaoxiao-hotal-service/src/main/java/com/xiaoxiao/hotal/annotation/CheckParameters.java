package com.xiaoxiao.hotal.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface CheckParameters {
}
