package com.naveen.mappingdemo.dao;

import com.naveen.mappingdemo.entity.*;

import java.util.List;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor find(int id);

    public void delete(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    List<Course> findMyCoursesByInstructorId(int id);

    Instructor findInstructorById(int theId);

    public void updateInstructor(Instructor instructor);

    public Course findCourseById(int id);

    public void updateCourse(Course course);

    public void deleteInstructor(int id);

    public void deleteCourse(int id);

    public void save(Course course);

    public Course findCourseAndReviewByCourseId(int id);


    public Course findCourseAndStudentsByCourseId(int id);

    public Student findStudentAndCourseByStudentId(int id);

    public void updateStudentCourses(Student student);

   public void deleteStudentById(int id);

   public Student findStudnetById(int id);
    }

