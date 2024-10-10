package com.naveen.kumar.mycoolapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFunController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }


    // expoose new end point for workout
@GetMapping("/workout")
    public String saySloganForWorkout(){
        return "Fitness ka dose, 45 min roz";
    }

    @GetMapping("/motivation")
    public String getMotivationalQuotes(){
        return "Success is not determined by the Results, but by the Process";
    }

}
