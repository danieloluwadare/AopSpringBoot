package com.example.kssaspect.MedAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(2)
public class AccessDisplayMethodSignature {
    @Pointcut(("execution(* com.example.kssaspect.controller.*.*(..))"))
    private void toAvoidPointCutDuplication(){}

    @Before("toAvoidPointCutDuplication()")
    public void displayMethodSignature(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

    }

    @Before("toAvoidPointCutDuplication()")
    public void AccessMethodSignature(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

//        Loop thru args
        for (Object tempArg:args){
            System.out.println(tempArg);
        }

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

    }
}
