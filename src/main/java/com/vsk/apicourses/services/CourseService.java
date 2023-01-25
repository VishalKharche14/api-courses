package com.vsk.apicourses.services;

import com.vsk.apicourses.entities.Courses;

import java.util.List;

public interface CourseService {
    public List<Courses> getCourses();

    Courses getCourses(long courseId);

    Courses addCourse(Courses course);

    Courses updateCourse(Courses course);
    void deleteCourse(long id);
}
