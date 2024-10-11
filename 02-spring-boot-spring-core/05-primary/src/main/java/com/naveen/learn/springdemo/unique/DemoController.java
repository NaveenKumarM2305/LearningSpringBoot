package com.naveen.learn.springdemo.unique;

import com.naveen.learn.springdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach theCoach;

    DemoController(Coach coach){
        theCoach=coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return theCoach.getDailyWorkout();
    }
}
