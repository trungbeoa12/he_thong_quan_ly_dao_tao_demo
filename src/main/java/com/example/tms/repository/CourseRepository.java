package com.example.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tms.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByCourseCodeIgnoreCase(String courseCode);

    List<Course> findByCourseCodeContainingIgnoreCaseOrCourseNameContainingIgnoreCaseOrderByCourseCode(
            String courseCode,
            String courseName);

    List<Course> findAllByOrderByCourseCode();
}
