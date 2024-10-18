package com.naveen.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {


    @RequestMapping("/showForm")
    public String showForm(){
        return "hellowold-form";
    }


    //Using @RequestParam
    @PostMapping("/showModelUsingRequestParameter")
    public String showModel2(@RequestParam("studentName") String theName, Model model){

        theName=theName.toUpperCase();


        // create a message
        String result= "This was added to model using @RequestParam(class-name) "+ theName;

        // add message to the model
        model.addAttribute("message",result);
        return "Helloworld";
    }

    // using HttpServletRequest
    @RequestMapping("/showModel")
    public String showModel(HttpServletRequest request, Model model){
        // get the request parameter from the HTML form
        String theName =  request.getParameter("studentName");
        // Process the data
        theName=theName.toUpperCase();


        // create a message
        String result= "This was added to model "+ theName;

        // add message to the model
        model.addAttribute("message",result);
        return "Helloworld";
    }


}