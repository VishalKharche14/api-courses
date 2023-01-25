package com.vsk.apicourses.services;

import com.vsk.apicourses.entities.Courses;
import com.vsk.apicourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourses(long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public Courses addCourse(Courses course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public Courses updateCourse(Courses course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.delete(courseRepository.findById(id).get());
    }
}
