package com.naveen.mappingdemo.dao;

import com.naveen.mappingdemo.entity.Course;
import com.naveen.mappingdemo.entity.Instructor;
import com.naveen.mappingdemo.entity.InstructorDetail;
import com.naveen.mappingdemo.entity.Review;

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

//    public List<Review> getReviewByCourseId(int id);
}
