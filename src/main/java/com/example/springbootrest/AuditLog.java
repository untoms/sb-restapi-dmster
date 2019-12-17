package com.example.springbootrest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AuditLog {

    private Logger logger = LoggerFactory.getLogger(AuditLog.class);

    @Before("execution(* com.example.springbootrest.sevices.UserServiceImpl.*(..))")
    public void before(){
        logger.info("before exec method");
    }

    @AfterReturning(value = "execution(* com.example.springbootrest.sevices.UserServiceImpl.*(..))",
    returning = "result")
    public void afterReturning(JoinPoint jp, Object result){
        logger.info("{} afterReturning {}", jp, result);
    }

    @After("execution(* com.example.springbootrest.sevices.UserServiceImpl.*(..))")
    public void after(JoinPoint jp){
        logger.info("{} after", jp);
    }

}
