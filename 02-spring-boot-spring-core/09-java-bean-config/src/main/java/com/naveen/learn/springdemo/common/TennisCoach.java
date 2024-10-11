package com.naveen.learn.springdemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements  Coach {

    TennisCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "Swing the Tennis bat for one hour!!";
    }
}
