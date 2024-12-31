package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);


// return-type class-name-method-name(args)
    @Before("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method called.");
    }

    @After("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method executed.");
    }

    @AfterThrowing("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method has some issues.");
    }

    @AfterReturning("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method executed successfully.");
    }
}
