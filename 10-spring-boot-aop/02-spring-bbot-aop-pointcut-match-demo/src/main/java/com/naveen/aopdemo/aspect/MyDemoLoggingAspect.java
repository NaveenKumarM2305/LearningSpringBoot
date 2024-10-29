package com.naveen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MyDemoLoggingAspect {


    // specifing fully qualified class name to only execute it for AccountDAOImpl's addAccount method
  /*  @Before("execution(public void com.naveen.aopdemo.dao.AccountDAOImpl.addAccount())")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add");
    }
    */




    // add* match any method which starts with add and followed by anything
  /*  @Before("execution(public void add*())")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }
*/




    // Matching with method having return type boolean and
    // add* match any method which starts with add and followed by anything
    // here the access specifier is optional, hence i will remove it
  /*  @Before("execution( boolean add*())")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }
*/

    // Matching with method having any return type and
    // add* match any method which starts with add and followed by anything
    // here the access specifier is optional, hence i will remove it
  /*  @Before("execution(* add*())")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }

   */

    // Matching with method having  return type Account object in the specified package and
    // add* match any method which starts with add and followed by anything
    // here the access specifier is optional, hence i will remove it
 /*   @Before("execution(* add*(com.naveen.aopdemo.dao.Account))")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }

  */


    // Matching with method having  return type Account object in the specified package and
    // ".." indicates ,Followed my any number of parameters with any type
    // add* match any method which starts with add and followed by anything
    // here the access specifier is optional, hence i will remove it
 /*   @Before("execution(* add*(com.naveen.aopdemo.dao.Account,..))")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }
  */


    // Matching with method having  any number of return type and any return type and
    // add* match any method which starts with add and followed by anything
    // here the access specifier is optional, hence i will remove it
  /*  @Before("execution(* add*(..))")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }
   */

// Matching with every method in the package and any clas in the package of  any return type and
// add* match any method which starts with add and followed by anything
// here the access specifier is optional, hence i will remove it
    @Before("execution(* com.naveen.aopdemo.dao.*.*(..))")
    public void demoBeforeAdvice(){
        System.out.println("Executing Before Advice for add*");
    }


}
