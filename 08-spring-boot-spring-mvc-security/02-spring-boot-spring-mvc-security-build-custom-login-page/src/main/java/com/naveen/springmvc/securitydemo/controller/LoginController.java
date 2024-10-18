package com.naveen.springmvc.securitydemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

 @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
     return "fancy-login";
 }

}
