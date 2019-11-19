package com.example.kssaspect.MedAspect.advice;

import com.example.kssaspect.model.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class AfterAdviceAspect {
//    this is used after a method  run regardless of its outcome wether successful or not
//    use case
//    Auditing logging
//   It doesnt throw exception
//


    //    Declare point cut and reusing
    @Pointcut(("execution(* com.example.kssaspect.controller.*.*(..))"))
    private void toAvoidPointCutDuplication(){}

    @Pointcut(("execution(* com.example.kssaspect.controller.*.get*(..))"))
    private void getter(){}

    @Pointcut(("execution(* com.example.kssaspect.controller.*.set*(..))"))
    private void setter(){}

//    @AfterReturning("execution(* com.example.kssaspect.controller.*.*(..))")
//    public void before(JoinPoint joinPoint) {
//
//
//
//    }


    @After(
          "toAvoidPointCutDuplication()"
    )
    public void performApiAnalytics(JoinPoint joinPoint) {
        System.out.println("Excetuing after finally");
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }



}
