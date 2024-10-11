package com.naveen.learn.springdemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {
CricketCoach(){
    System.out.println("cricket here");
}
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 min strait...";
    }




}
