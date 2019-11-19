package com.example.kssaspect.MedAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
@Configuration
public class UserAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(*  com.example.kssaspect.controller.UserController.create())")
    public void before(JoinPoint joinPoint) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        auth.getDetails();

        //Advice
//        logger.info(" Check for user access "+ principal.getName());
        logger.info(" Allowed execution for {}", joinPoint);
    }

}
