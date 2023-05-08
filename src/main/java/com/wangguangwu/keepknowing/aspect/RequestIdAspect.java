package com.wangguangwu.keepknowing.aspect;

import com.wangguangwu.keepknowing.context.RequestContext;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author wangguangwu
 */
@Aspect
@Component
public class RequestIdAspect {

    @Pointcut("execution(* com.wangguangwu.keepknowing.controller..*.*(..))")
    public void point() {
    }

    @Before("point()")
    public void addRequestId() {
        String requestId = UUID.randomUUID().toString();
        // 添加 id
        RequestContext.setRequestId(requestId);
    }

    @AfterReturning("point()")
    public void removeRequestIdAfterReturning() {
        // 清除 id
        RequestContext.clear();
    }

    @AfterThrowing("point()")
    public void removeRequestIdAfterThrowing() {
        // 清除 id
        RequestContext.clear();
    }

}
