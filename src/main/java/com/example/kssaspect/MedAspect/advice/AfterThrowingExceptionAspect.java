package com.example.kssaspect.MedAspect.advice;

import com.example.kssaspect.model.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class AfterThrowingExceptionAspect {
//    use case
//    Auditing logging
//    Post processing data e.g  format data or enrich data (its cool but be careful)
//


    //    Declare point cut and reusing
    @Pointcut(("execution(* com.example.kssaspect.controller.*.*(..))"))
    private void toAvoidPointCutDuplication(){}

    @Pointcut(("execution(* com.example.kssaspect.controller.*.get*(..))"))
    private void getter(){}

    @Pointcut(("execution(* com.example.kssaspect.controller.*.set*(..))"))
    private void setter(){}

    @AfterReturning("execution(* com.example.kssaspect.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {



    }


    @AfterThrowing(
            pointcut = "toAvoidPointCutDuplication()",
            throwing = "myexception"
    )
    public void reportException(JoinPoint joinPoint, Throwable myexception) {
        System.out.println("Exception is "+ myexception);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }




}
