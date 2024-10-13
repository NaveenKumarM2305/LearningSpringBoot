package com.naveen.restdemo.rest;

import com.naveen.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Naveen","Kumar M"));
        students.add(new Student("Vinay","Kumar M"));
        students.add(new Student("Praveen","Kumar M"));

        return students;
    }
}
