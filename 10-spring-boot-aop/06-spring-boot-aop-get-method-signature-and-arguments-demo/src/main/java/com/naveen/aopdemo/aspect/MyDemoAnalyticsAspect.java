package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoAnalyticsAspect {

    @Before("com.naveen.aopdemo.aspect.DemoPointcutDeclaration.applytoAllExceptGettersAndSetters()")
    private void applyAnalytics(){
        System.out.println(" \n===>>>Applying Analytics order(2)");
    }
}
