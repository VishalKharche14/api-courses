package com.vsk.apicourses.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Instructor {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(mappedBy = "currInstructor")
    @JsonBackReference
    private Courses currCourse;

    public Instructor() {
    }

    public Instructor(Long id, String firstName, String lastName, String email, Courses currCourse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.currCourse = currCourse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Courses getCurrCourse() {
        return currCourse;
    }

    public void setCurrCourse(Courses currCourse) {
        this.currCourse = currCourse;
    }
}
