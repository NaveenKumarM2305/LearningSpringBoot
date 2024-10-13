package com.naveen.curddemo.rest;

import com.naveen.curddemo.dao.EmployeeDao;
import com.naveen.curddemo.entity.Employee;
import com.naveen.curddemo.service.EmployeeService;
import com.naveen.curddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // declare EmployeeDao
   private EmployeeService employeeService;

   // Constructor injection of employeeService
    @Autowired
    EmployeeRestController( EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    // method to expoose a list of employess
    @GetMapping("/employees")
    private List<Employee> findAll(){
    List<Employee> employees= employeeService.findAll();
    return employees;
    }

    // to expose the employee based on id
    // using @PathVariable and "/employees/"{employeeId}"
    @GetMapping("/employees/{employeeId}")
    private Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee not found : "+employeeId);

        }
        return employee;
    }

    // to update or insert employee
    // set id=0 because when we are updating the employee, we update employeeid
    // if the employee is new we insert or else we update their id

    @PostMapping("/employees")
    private Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee emp = employeeService.save(employee);
        // make sure to return the updated employee and not the old one
        return emp;
    }

    @PutMapping("/employees")
    private Employee updateEmployee(@RequestBody Employee employee){
       Employee emp =employeeService.save(employee);
       return emp;
    }

    @DeleteMapping("employees/{employeeId}")
    private String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee== null){
            throw new RuntimeException("Employee Id not found: "+employeeId);

        }
        employeeService.deleteById(employeeId);
        return "Employee deleted with id"+employeeId;
    }


}
