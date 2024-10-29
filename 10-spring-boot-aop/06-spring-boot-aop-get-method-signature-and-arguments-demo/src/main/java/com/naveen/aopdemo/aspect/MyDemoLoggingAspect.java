package com.naveen.aopdemo.aspect;

import com.naveen.aopdemo.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.naveen.aopdemo.aspect.DemoPointcutDeclaration.applytoAllExceptGettersAndSetters()")
    private void display(JoinPoint theJointPoint){
        System.out.println("\n ===>>> Executing to all except Setters and Getters order(1)");

    // Accessing the method's signature
        MethodSignature theMethodSignature = (MethodSignature) theJointPoint.getSignature();
        System.out.println("method : "+theMethodSignature);

        // Accessing the method's arguments

        Object[] args= theJointPoint.getArgs();
        for(Object tempArgs : args){
            System.out.println(tempArgs);

            // Check if type of Account
            if(tempArgs instanceof Account theAccount){
                //if yes then downcast it and print the specific things
                System.out.println(theAccount.getName());
                System.out.println(theAccount.getAccno());
            }
        }


    }


}
