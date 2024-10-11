package com.naveen.learn.springdemo.unique;

import com.naveen.learn.springdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach FirstCoach;


    DemoController(@Qualifier("mySwimCoach") Coach coach1){

        FirstCoach=coach1;

    }


@GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return FirstCoach.getDailyWorkout();
}
}
