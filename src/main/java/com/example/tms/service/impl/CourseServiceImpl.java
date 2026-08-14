package com.example.tms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.tms.dto.CourseDto;
import com.example.tms.entity.Course;
import com.example.tms.exception.BusinessException;
import com.example.tms.mapper.CourseMapper;
import com.example.tms.repository.CourseRepository;
import com.example.tms.service.AuditLogService;
import com.example.tms.service.CourseService;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final AuditLogService auditLogService;

    public CourseServiceImpl(
            CourseRepository courseRepository,
            CourseMapper courseMapper,
            AuditLogService auditLogService) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.auditLogService = auditLogService;
    }

    @Override
    public List<CourseDto> search(String keyword) {
        List<Course> courses;
        if (StringUtils.hasText(keyword)) {
            String value = keyword.trim();
            courses = courseRepository.findByCourseCodeContainingIgnoreCaseOrCourseNameContainingIgnoreCaseOrderByCourseCode(value, value);
        } else {
            courses = courseRepository.findAllByOrderByCourseCode();
        }
        return courses.stream().map(courseMapper::toDto).toList();
    }

    @Override
    @Transactional
    public CourseDto create(CourseDto dto) {
        String code = dto.getCourseCode().trim().toUpperCase();
        if (courseRepository.existsByCourseCodeIgnoreCase(code)) {
            throw new BusinessException("Mã course đã tồn tại: " + code);
        }

        Course course = new Course();
        course.setCourseCode(code);
        course.setCourseName(dto.getCourseName().trim());
        course.setCategory(dto.getCategory());
        course.setDescription(dto.getDescription());
        course.setTrainingType(dto.getTrainingType());
        course.setTrainingMethod(dto.getTrainingMethod());
        course.setDefaultDurationHours(dto.getDefaultDurationHours());
        course.setTargetAudience(dto.getTargetAudience());
        course.setStatus(dto.getStatus());

        Course saved = courseRepository.save(course);
        auditLogService.log("system", "CREATE", "COURSE", saved.getId().toString(), null, saved.getCourseCode());
        return courseMapper.toDto(saved);
    }
}
