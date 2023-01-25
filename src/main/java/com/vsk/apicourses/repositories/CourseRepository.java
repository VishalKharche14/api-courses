package com.vsk.apicourses.repositories;

import com.vsk.apicourses.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
