package com.naveen.curddemo.dao;

import com.naveen.curddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements  EmployeeDao{

    // define entityManager
    EntityManager entityManager;

    // EntityManager injection using constructor injection
     @Autowired
     public  EmployeeDaoImpl(EntityManager entityManager){
         this.entityManager=entityManager;
     }

    @Override
    public List<Employee> findAll() {
         // Create a Query to get all the employees
         TypedQuery<Employee> TheQuery = entityManager.createQuery("From Employee",Employee.class);
        // Process the query to get the result list
         List<Employee> employees= TheQuery.getResultList();
        // return the results
         return employees;
    }

    @Override
    public Employee findById(int id) {
       Employee emp = entityManager.find(Employee.class,id);
       return emp;
    }

    @Override
    public Employee save(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);

    }


}
