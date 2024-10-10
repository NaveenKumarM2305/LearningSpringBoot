package com.naveen.kumar.mycoolapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFunController {

    // To Inject the name.first and name.last
    @Value("${name.first}")
    private String firstName;

    @Value("${name.last}")
    private String lastName;



    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/myname")
    public String getName(){
        return "Name: "+firstName+" "+lastName;
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
