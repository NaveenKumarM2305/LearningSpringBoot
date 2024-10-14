package com.naveen.curddemo.service;

import com.naveen.curddemo.dao.EmployeeDao;
import com.naveen.curddemo.dao.EmployeeDaoImpl;
import com.naveen.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    private EmployeeDao employeeDao;

    // constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(int  id) {
        employeeDao.deleteById(id);

    }
}
