package com.naveen.curddemo.service;


import com.naveen.curddemo.entity.Employee;
import com.naveen.curddemo.jparepo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    private EmployeeRepository employeeRepository;

    // constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
       Optional<Employee> result = employeeRepository.findById(id);
       Employee emp = null;
       if(result.isPresent()){
           emp=result.get();

       }
       else {
           throw new RuntimeException("Employee not found : "+id);
       }


       return emp;
    }

    @Override
// We dont need @Transactional here as JPA will take care of it
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
// We dont need @Transactional here as JPA will take care of it
    @Override
    public void deleteById(int  id) {
        employeeRepository.deleteById(id);

    }
}
