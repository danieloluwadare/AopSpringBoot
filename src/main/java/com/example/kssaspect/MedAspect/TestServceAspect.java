package com.example.kssaspect.MedAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration

public class TestServceAspect {
    @Pointcut(("execution(* com.example.kssaspect.service.*.*(..))"))
    private void toAvoidPointCutDuplication(){}

    @Before("execution(* com.example.kssaspect.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("From TestServceAspect it ran" );
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.kssaspect.service.*.*(..))",
            throwing = "myexception"
    )
    public void reportException(JoinPoint joinPoint, Throwable myexception) {
        System.out.println("Exception reportException is "+ myexception);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }

}
