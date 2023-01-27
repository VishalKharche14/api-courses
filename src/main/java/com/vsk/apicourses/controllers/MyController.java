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
    public ResponseEntity<List<Courses>> getCourses(){
        try{
            List<Courses> coursesList = this.courseService.getCourses();
            return ResponseEntity.status(HttpStatus.OK).body(coursesList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Courses> getCourse(@PathVariable long courseId){
        try{
            Courses course = this.courseService.getCourses(courseId);
            return ResponseEntity.status(HttpStatus.OK).body(course);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/courses")
    public ResponseEntity<Courses> addCourse(@RequestBody Courses course){
        try{
            this.courseService.addCourse(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(course);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
    }
    @PutMapping("/courses")
    public ResponseEntity<Courses> updateCourse(@RequestBody Courses course){
        try{
            this.courseService.updateCourse(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(course);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId){
        try {
            this.courseService.deleteCourse(courseId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
