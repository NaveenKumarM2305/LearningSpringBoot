package com.naveen.restdemo.rest;

import com.naveen.restdemo.entity.Student;
import com.naveen.restdemo.exceptionhandling.StudentErrorResponse;
import com.naveen.restdemo.exceptionhandling.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    @PostConstruct
    public void loadStudents(){
        students = new ArrayList<>();
        students.add(new Student("Naveen","Kumar M"));
        students.add(new Student("Vinay","Kumar M"));
        students.add(new Student("Praveen","Kumar M"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){


        return students;
    }



    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        // As of now assuming the studentId is the index of student object in Arraylist

        // If the condtions are not met, then excpetion is thrown
        // and the program controls exit from this program
        // and goes to @ExceptionHandler


        if(students.size()<studentId || studentId<0){
            throw  new StudentNotFoundException("Student Not found: "+studentId);
        }


        return students.get(studentId);



    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> customExceptionHandling(StudentNotFoundException exec){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exec.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
