package com.vsk.apicourses.controllers;

import com.vsk.apicourses.entities.Courses;
import com.vsk.apicourses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//REST -> Representational State Transfer
public class MyController {


    private final CourseService courseService;

    public MyController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Courses>> getCourses(){
        List<Courses> courses = this.courseService.getCourses();
        if(courses.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(courses));
    }
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Courses> getCourse(@PathVariable long courseId){
        List<Courses> coursesList = this.courseService.getCourses().stream().filter(c -> c.getId() == courseId).collect(Collectors.toList());
        if(coursesList.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(coursesList.get(0)));
    }
    @PostMapping("/courses")
    public ResponseEntity<Courses> addCourse(@RequestBody Courses course){
        List<Courses> coursesList = courseService.getCourses().stream().filter(c -> c.getId() == course.getId()).toList();
        if(coursesList.size()==1){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
        this.courseService.addCourse(course);
        return ResponseEntity.of(Optional.of(course));
    }
    @PutMapping("/courses")
    public ResponseEntity<Courses> updateCourse(@RequestBody Courses course){
        List<Courses> coursesList = courseService.getCourses().stream().filter(c -> c.getId() == course.getId()).toList();
        if(coursesList.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.courseService.updateCourse(course);
        return ResponseEntity.of(Optional.of(course));
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId){
        try {
            this.courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
