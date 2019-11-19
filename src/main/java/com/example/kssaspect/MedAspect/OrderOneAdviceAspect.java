package com.example.kssaspect.MedAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
@Configuration
@Order(1)
public class OrderOneAdviceAspect {
    @Pointcut(("execution(* com.example.kssaspect.controller.*.*(..))"))
    private void toAvoidPointCutDuplication(){}

    @Before("toAvoidPointCutDuplication()")
    public void performDatabseAnalytics(JoinPoint joinPoint) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }
}
