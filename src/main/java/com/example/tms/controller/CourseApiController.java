package com.example.tms.controller;

import java.util.List;

import com.example.tms.dto.CourseDto;
import com.example.tms.service.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','TRAINING_ADMIN')")
public class CourseApiController {

    private final CourseService courseService;

    public CourseApiController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/api/courses")
    public List<CourseDto> list(@RequestParam(defaultValue = "") String keyword) {
        return courseService.search(keyword);
    }
}
