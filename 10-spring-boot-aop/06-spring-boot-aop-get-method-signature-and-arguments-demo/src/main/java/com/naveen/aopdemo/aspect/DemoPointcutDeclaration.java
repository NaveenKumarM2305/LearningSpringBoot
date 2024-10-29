package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoPointcutDeclaration {
    @Pointcut("execution(* com.naveen.aopdemo.dao.*.*(..))")
    public void applytoAll(){}

    @Pointcut("execution(* com.naveen.aopdemo.dao.*.set*(..))")
    public  void appytoSetters(){}


    @Pointcut("execution(* com.naveen.aopdemo.dao.*.get*(..))")
    public  void appytoGetters(){}

    @Pointcut("applytoAll() && ! (appytoSetters() || appytoGetters())")
    public void applytoAllExceptGettersAndSetters(){
    }

}
