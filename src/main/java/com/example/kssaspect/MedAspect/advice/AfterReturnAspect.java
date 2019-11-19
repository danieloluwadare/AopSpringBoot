package com.example.kssaspect.MedAspect.advice;

import com.example.kssaspect.model.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class AfterReturnAspect {
//    this is used after a method succussfully run
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


    @AfterReturning(
            pointcut = "toAvoidPointCutDuplication()",
            returning = "result"
    )
    public void performApiAnalytics(JoinPoint joinPoint, List<Transaction> result) {
        System.out.println("result is "+ result);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }

//    combining pointcut declaration
    @Pointcut("toAvoidPointCutDuplication() && !(getter()|| setter())")
    public void forOtherMethodsExceptGettersAndSetters(){}

    @AfterReturning("forOtherMethodsExceptGettersAndSetters()")
    public void performApiAnalyticsExceptGetterAndSetter(JoinPoint joinPoint) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

    }


}
