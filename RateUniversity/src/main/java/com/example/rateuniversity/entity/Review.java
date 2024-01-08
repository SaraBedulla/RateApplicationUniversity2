package com.project.rateuniapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "rating")
    private int rating;

    @Column(name = "date")
    private Date date;
    public Review(){

    }

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", course=" + course +
                ", student=" + student +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}
