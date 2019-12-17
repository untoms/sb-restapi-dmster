package com.example.springbootrest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//@Aspect
//@Configuration
public class AuditLog {

//    private Logger logger = LoggerFactory.getLogger(AuditLog.class);
//
//    @Pointcut(value = "execution(* com.example.springbootrest.sevices.UserServiceImpl.*(..))")
//    private void logDisplaying(){
//
//    }
//
//    @Around(value = "logDisplaying()")
//    public void aroundAdvice(ProceedingJoinPoint p) throws Throwable {
//
//        logger.info("Inside aroundAdvice() method..."+"Inserted before="+ p.getSignature().getName() +" method");
//        p.proceed();
//        try {
//            p.proceed();
//        } catch (Throwable t){
//            logger.info("Inside aroundAdvice() method..."+"Errr="+ p.getSignature().getName() +" method, err :"+t.getMessage());
//            throw t;
//        }finally {
//            logger.info("Inside finally block");
//        }

//        logger.info("Inside aroundAdvice() method..."+"Inserted after="+ p.getSignature().getName() +" method");
//    }

}
