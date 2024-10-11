package com.naveen.learn.springdemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach {
    public String getDailyWorkout(){
        return "Swing the Tennis bat for one hour!!";
    }
}
