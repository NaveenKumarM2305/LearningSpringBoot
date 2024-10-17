package com.naveen.springboot.thymeleafdemo.controller;

import com.naveen.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${favoriteLanguage}")
    private List<String> favoriteLanguage;

    @Value("${systems}")
    private List<String> favoriteSystem;
    @GetMapping("/form")
    public String form(Model model){
        Student theStudent= new Student();
        model.addAttribute("student",theStudent);
        model.addAttribute("countries",countries);
        model.addAttribute("favoriteLanguage",favoriteLanguage);
        model.addAttribute("system",favoriteSystem);
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        System.out.println("theStudent object has : "+theStudent.getFirstName()+" "+theStudent.getLastName() +" "+theStudent.getCountry()+theStudent.getFavoriteLanguage());
        return "student-confirmation";
    }
}
