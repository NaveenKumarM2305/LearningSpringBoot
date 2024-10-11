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

    @PostConstruct
    public void doSomestartupThings(){
        System.out.println("Started when run:" +getClass().getSimpleName());
    }

    @PreDestroy
    public void doSomeDestroyThings(){
        System.out.println("Will run once the program is stopped: "+getClass().getSimpleName());
    }


}
