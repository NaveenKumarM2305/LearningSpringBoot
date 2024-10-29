package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MyDemoLoggingAspect {

   // Implementing combining pointcut

    /*
    Task: to apply to every methods except setters and getters
    step1: set Pointcut for every methods
    step2: set Pointcut for setters and getters
    step3: combine all these to set Pointcut to every methods
            except setters and getters using logical operators
     */

    @Pointcut("execution(* com.naveen.aopdemo.dao.*.*(..))")
    private void applytoAll(){}

    @Pointcut("execution(* com.naveen.aopdemo.dao.*.set*(..))")
    private  void appytoSetters(){}


    @Pointcut("execution(* com.naveen.aopdemo.dao.*.get*(..))")
    private  void appytoGetters(){}

    @Pointcut("applytoAll() && ! (appytoSetters() || appytoGetters())")
    private void applytoAllExceptGettersAndSetters(){
    }

    @Before("applytoAllExceptGettersAndSetters()")
    private void display(){
        System.out.println("===>>> Executing to all except Setters and Getters");
    }


}
