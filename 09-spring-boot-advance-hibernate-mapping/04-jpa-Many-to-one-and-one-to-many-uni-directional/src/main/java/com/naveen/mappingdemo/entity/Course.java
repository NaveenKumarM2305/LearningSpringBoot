package com.naveen.mappingdemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// make the class as entity and name it
@Entity
@Table(name="course")
public class Course {



    // define the fields and requried annoation
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    // add Insturctor field and add @ManytoOne
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Reviews
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    List<Review> reviews ;


    // create constructors
Course(){

}

    public Course(String title) {
        this.title = title;
    }


    // generate setters and getters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //override tostring

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +

                '}';
    }

    public void addReview(Review review){
    if(reviews==null){
        reviews= new ArrayList<>();
    }
    reviews.add(review);

    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
