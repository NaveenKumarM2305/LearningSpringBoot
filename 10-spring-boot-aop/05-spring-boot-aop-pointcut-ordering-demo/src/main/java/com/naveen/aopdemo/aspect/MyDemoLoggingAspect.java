package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.naveen.aopdemo.aspect.DemoPointcutDeclaration.applytoAllExceptGettersAndSetters()")
    private void display(){
        System.out.println("\n ===>>> Executing to all except Setters and Getters order(1)");
    }


}
