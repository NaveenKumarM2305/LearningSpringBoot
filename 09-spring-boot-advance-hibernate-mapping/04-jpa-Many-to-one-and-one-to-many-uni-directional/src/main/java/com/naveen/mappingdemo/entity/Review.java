package com.naveen.mappingdemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {

    // define fields

    // annotate the fieldsprivate int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "comment")
    private String review;




    // define constructors

    Review(){

    }
    public Review(String review) {
        this.review = review;
    }

    // generate setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    // override toString

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
                '}';
    }



}
