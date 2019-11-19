package com.example.kssaspect.MedAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
@Configuration
public class AspectExecution {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Around("@annotation(LogExecutionTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

        logger.info("Lets find out if it actually logs ");
        Object result =null;
        try {
             result =joinPoint.proceed();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  result;
    }

}
