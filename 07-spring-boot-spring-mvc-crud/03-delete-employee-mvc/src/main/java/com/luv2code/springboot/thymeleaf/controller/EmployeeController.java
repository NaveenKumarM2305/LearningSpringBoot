package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.entity.Employee;
import com.luv2code.springboot.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;
    @Autowired
    EmployeeController( EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee emp = new Employee();
        theModel.addAttribute("employee",emp);
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        // Save to the Database
        employeeService.save(theEmployee);
        // redirect to the emp list page to avoid duplicate submitting
        return "redirect:/employees/list";

    }

   @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("employeeId") int id
   ,Model theModel){
        //Find the employee using the employeeid that was passed on url
        Employee employee = employeeService.findById(id);
        // Add to the Model
        theModel.addAttribute(employee);
        // return the form
        return "/employees/employee-form";
   }

        @GetMapping("/delete")
       public String delteEmployee(@RequestParam("employeeId") int id){



              employeeService.deleteById(id);

              return "redirect:/employees/list";

       }

}
