package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyDemoAPI {

    @Before("com.naveen.aopdemo.aspect.DemoPointcutDeclaration.applytoAllExceptGettersAndSetters()")
    private void checkAPI()
    {
        System.out.println("\n ====>>>> Checking API  @Order(3)");
    }}

