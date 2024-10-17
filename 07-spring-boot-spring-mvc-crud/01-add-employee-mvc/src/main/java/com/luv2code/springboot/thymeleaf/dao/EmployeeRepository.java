package com.luv2code.springboot.thymeleaf.dao;

import com.luv2code.springboot.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    // that's it ... no need to write any code LOL!


    // to sort the employees by first Name
    public List<Employee> findAllByOrderByFirstNameAsc();

}
