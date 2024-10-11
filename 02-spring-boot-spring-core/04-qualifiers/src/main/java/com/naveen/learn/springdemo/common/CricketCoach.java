package com.naveen.learn.springdemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 min strait...";
    }
}
