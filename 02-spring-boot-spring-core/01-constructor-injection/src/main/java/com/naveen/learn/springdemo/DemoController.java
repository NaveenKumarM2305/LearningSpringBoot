package com.naveen.learn.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach theCoach;
    @Autowired
    DemoController(Coach coach){
        theCoach=coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return theCoach.getDailyWorkout();
    }
}
