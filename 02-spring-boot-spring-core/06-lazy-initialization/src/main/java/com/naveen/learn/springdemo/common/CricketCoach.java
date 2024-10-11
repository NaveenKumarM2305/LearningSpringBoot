package com.naveen.learn.springdemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {
    CricketCoach(){
        System.out.println("Constructor: "+ getClass());
    }
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 min strait...";
    }
}
