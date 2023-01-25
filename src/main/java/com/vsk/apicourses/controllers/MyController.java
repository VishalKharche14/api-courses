package com.vsk.apicourses.controllers;

import com.vsk.apicourses.entities.Courses;
import com.vsk.apicourses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//REST -> Representational State Transfer
public class MyController {


    private final CourseService courseService;

    public MyController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return this.courseService.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable long courseId){
        return this.courseService.getCourses(courseId) ;
    }
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }
    @PutMapping("/courses")
    public Courses updateCourse(@RequestBody Courses course){
        return this.courseService.updateCourse(course);
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
