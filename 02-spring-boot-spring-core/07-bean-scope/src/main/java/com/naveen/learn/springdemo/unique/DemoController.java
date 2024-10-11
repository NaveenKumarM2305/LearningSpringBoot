package com.naveen.learn.springdemo.unique;

import com.naveen.learn.springdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach FirstCoach;
    private Coach SecondCoach;

    DemoController(@Qualifier("cricketCoach") Coach coach1,@Qualifier("cricketCoach") Coach coach2){

        FirstCoach=coach1;
        SecondCoach=coach2;
    }

    @GetMapping("/check")
    public String check(){
        return "FirstCoach==SecondCoach: "+ (FirstCoach==SecondCoach);
    }
@GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return FirstCoach.getDailyWorkout();
}
}
