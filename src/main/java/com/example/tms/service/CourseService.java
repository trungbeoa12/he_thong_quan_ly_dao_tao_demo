package com.example.tms.service;

import java.util.List;

import com.example.tms.dto.CourseDto;

public interface CourseService {

    List<CourseDto> search(String keyword);

    CourseDto create(CourseDto dto);
}
