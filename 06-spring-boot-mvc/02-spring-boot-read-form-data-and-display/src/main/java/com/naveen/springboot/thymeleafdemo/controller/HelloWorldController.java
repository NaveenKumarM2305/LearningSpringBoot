package com.naveen.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {


    @RequestMapping("/showForm")
    public String showForm(){
        return "hellowold-form";
    }

    @RequestMapping("/processForm")
    public String processFoorm(){
        return "helloworld";
    }
}
