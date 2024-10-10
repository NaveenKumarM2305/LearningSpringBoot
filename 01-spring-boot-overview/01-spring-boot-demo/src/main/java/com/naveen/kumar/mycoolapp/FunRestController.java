package com.naveen.kumar.mycoolapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/"
@GetMapping("/")
    public  String sayHello(){
        return "Hello World!!!";
    }
}
