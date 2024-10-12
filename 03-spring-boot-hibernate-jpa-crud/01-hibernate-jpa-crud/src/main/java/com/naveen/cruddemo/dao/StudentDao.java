package com.naveen.cruddemo.dao;

import com.naveen.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
   void save(Student student);
   Student findById(int stuId);

   List<Student> findAll();
   List<Student> findByFirstName(String firstName);
   void update(Student student);
   void deleteById(int studentId);
   int deleteAll();
}
