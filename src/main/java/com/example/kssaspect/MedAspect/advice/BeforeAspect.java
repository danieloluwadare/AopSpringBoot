package com.example.kssaspect.MedAspect.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {

//    Declare point cut and reusing
    @Pointcut(("execution(* com.example.kssaspect.controller.*.*(..))"))
    private void toAvoidPointCutDuplication(){}

    @Pointcut(("execution(* com.example.kssaspect.controller.*.get*(..))"))
    private void getter(){}

    @Pointcut(("execution(* com.example.kssaspect.controller.*.set*(..))"))
    private void setter(){}

    @Before("execution(* com.example.kssaspect.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {



    }


    @Before("toAvoidPointCutDuplication()")
    public void performApiAnalytics(JoinPoint joinPoint) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }

//    combining pointcut declaration
    @Pointcut("toAvoidPointCutDuplication() && !(getter()|| setter())")
    public void forOtherMethodsExceptGettersAndSetters(){}

    @Before("forOtherMethodsExceptGettersAndSetters()")
    public void performApiAnalyticsExceptGetterAndSetter(JoinPoint joinPoint) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }


}
