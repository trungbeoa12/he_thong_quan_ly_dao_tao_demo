package com.example.tms.mapper;

import org.springframework.stereotype.Component;

import com.example.tms.dto.CourseDto;
import com.example.tms.entity.Course;

@Component
public class CourseMapper {

    public CourseDto toDto(Course entity) {
        CourseDto dto = new CourseDto();
        dto.setId(entity.getId());
        dto.setCourseCode(entity.getCourseCode());
        dto.setCourseName(entity.getCourseName());
        dto.setCategory(entity.getCategory());
        dto.setDescription(entity.getDescription());
        dto.setTrainingType(entity.getTrainingType());
        dto.setTrainingMethod(entity.getTrainingMethod());
        dto.setDefaultDurationHours(entity.getDefaultDurationHours());
        dto.setTargetAudience(entity.getTargetAudience());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
