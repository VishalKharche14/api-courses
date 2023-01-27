package com.vsk.apicourses.services;

import com.vsk.apicourses.entities.Courses;
import com.vsk.apicourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> getCourses() throws Exception {
        List<Courses> coursesList = courseRepository.findAll();
        if(coursesList.isEmpty()) throw new Exception("No any course is available right now");
        return coursesList;
    }

    @Override
    public Courses getCourses(long courseId) throws Exception {
        Optional<Courses> course = courseRepository.findById(courseId);
        if(course.isEmpty()) throw new Exception("No Course Found with id : "+courseId);
        return course.get() ;
    }

    @Override
    public Courses addCourse(Courses course) throws Exception {
        Optional<Courses> oldCourse = courseRepository.findById(course.getId());
        if(oldCourse.isPresent()) {
            throw new Exception("Course Already exists with same id : "+course.getId());
        }
        courseRepository.save(course);
        return course;
    }

    @Override
    public Courses updateCourse(Courses course) throws Exception {
        Optional<Courses> oldCourse = courseRepository.findById(course.getId());
        if(oldCourse.isPresent()) {
            courseRepository.save(course);
            return course;
        }
        throw new Exception("Course with id : "+course.getId()+" does not exists");
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.delete(courseRepository.findById(id).get());
    }
}
