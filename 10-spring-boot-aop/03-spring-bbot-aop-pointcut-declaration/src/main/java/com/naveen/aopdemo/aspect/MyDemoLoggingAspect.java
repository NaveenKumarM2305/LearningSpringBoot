package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MyDemoLoggingAspect {

    // Pointcut delaration
    @Pointcut("execution(* com.naveen.aopdemo.dao.*.*(..))")
    private void pointcutDeclartionHere() {
    }

    // using Pointcut declaration using the method name
    @Before("pointcutDeclartionHere()")
    public void demoBeforeAdvice() {
        System.out.println("\n======>>>>Executing Before Advice for every method in the package dao");
    }

    @Before("pointcutDeclartionHere()")
    public void doAPIAnalytics() {
        System.out.println("\n =====>>Doing some analytics");
    }
}