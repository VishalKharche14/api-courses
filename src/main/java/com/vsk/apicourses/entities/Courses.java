package com.vsk.apicourses.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Courses {
    @Id
    private long id;
    private String title;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Instructor currInstructor;

    public Courses() {
    }
    public Courses(long id, String title, String description, Instructor currInstructor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.currInstructor = currInstructor;
    }

    public Instructor getCurrInstructor() {
        return currInstructor;
    }

    public void setCurrInstructor(Instructor currInstructor) {
        this.currInstructor = currInstructor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
