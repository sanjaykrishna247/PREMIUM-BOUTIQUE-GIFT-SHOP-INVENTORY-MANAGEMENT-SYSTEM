package com.examly.springapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Log before any controller method
    @Before("execution(* com.examly.springapp.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println(
            "➡️ Entering method: " + joinPoint.getSignature().getName()
        );
    }

    // Log after any service method returns
    @AfterReturning(
        pointcut = "execution(* com.examly.springapp.service.*.*(..))",
        returning = "result"
    )
    public void logAfterService(JoinPoint joinPoint, Object result) {
        System.out.println(
            "✅ Exiting method: " + joinPoint.getSignature().getName()
        );
    }
}
