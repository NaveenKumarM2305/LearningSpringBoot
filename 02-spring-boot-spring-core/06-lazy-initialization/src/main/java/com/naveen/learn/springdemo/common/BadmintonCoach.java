package com.naveen.learn.springdemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BadmintonCoach  implements  Coach{
    BadmintonCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Move around with that cock swiftly";
    }
}
