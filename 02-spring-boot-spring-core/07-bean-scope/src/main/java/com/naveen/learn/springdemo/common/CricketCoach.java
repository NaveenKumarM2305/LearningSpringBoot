package com.naveen.learn.springdemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
CricketCoach(){
    System.out.println("cricket here");
}
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 min strait...";
    }
}
