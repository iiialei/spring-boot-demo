package com.xkcoding.dubbo.consumer.controller;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    String name()default "程文潮";
}
