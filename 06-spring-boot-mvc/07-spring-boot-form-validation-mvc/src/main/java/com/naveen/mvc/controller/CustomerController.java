package com.naveen.mvc.controller;

import com.naveen.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String showForm(Model themodel){
        themodel.addAttribute("customer",new Customer());
        return "customer-form";
    }

    @PostMapping("/validateForm")
    public String validateForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                               BindingResult theBindingResult){
        System.out.println(theCustomer.getLastName());
        System.out.println("--------------------------------------------");
        System.out.println("Binding result: "+theBindingResult.toString());
        System.out.println("_____________________________________________");
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        else{
            return "confirm-customer";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
}
