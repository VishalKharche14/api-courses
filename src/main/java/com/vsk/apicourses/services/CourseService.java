package com.vsk.apicourses.services;

import com.vsk.apicourses.entities.Courses;

import java.util.List;

public interface CourseService {
    public List<Courses> getCourses() throws Exception;

    Courses getCourses(long courseId) throws Exception;

    Courses addCourse(Courses course) throws Exception;

    Courses updateCourse(Courses course) throws Exception;
    void deleteCourse(long id);
}
