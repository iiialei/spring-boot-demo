package com.xkcoding.dubbo.consumer.interceptor;

import com.xkcoding.dubbo.consumer.controller.Cache;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.hasMethodAnnotation(GetMapping.class) && methodParameter.hasMethodAnnotation(Cache.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Cache cache = methodParameter.getMethodAnnotation(Cache.class);
        o = cache.name();
        System.out.println("重新定义返回数据成功");
        System.out.println("准备返回数据给前台");
        return o;
    }
}
