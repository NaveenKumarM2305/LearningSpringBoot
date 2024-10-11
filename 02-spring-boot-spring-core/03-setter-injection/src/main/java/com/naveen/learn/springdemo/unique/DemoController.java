package com.naveen.learn.springdemo.unique;

import com.naveen.learn.springdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach theCoach;


    //SETTER METHOD NAMED setCoach
    /*
    @Autowired
    public void setCoach(Coach coach){
        theCoach=coach;
    }
*/


    // WE CAN HAVE ANY NAMES FOR SETTER METHOD
    @Autowired
    public void anyRandomMethodUsedAsSetter(Coach coach){
        theCoach= coach;

    }
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return theCoach.getDailyWorkout();
    }
}
