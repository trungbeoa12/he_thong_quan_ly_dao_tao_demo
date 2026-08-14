package com.example.tms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.tms.dto.InstructorDto;
import com.example.tms.entity.Instructor;
import com.example.tms.exception.BusinessException;
import com.example.tms.mapper.InstructorMapper;
import com.example.tms.repository.InstructorRepository;
import com.example.tms.service.AuditLogService;
import com.example.tms.service.InstructorService;

@Service
@Transactional(readOnly = true)
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final AuditLogService auditLogService;

    public InstructorServiceImpl(
            InstructorRepository instructorRepository,
            InstructorMapper instructorMapper,
            AuditLogService auditLogService) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
        this.auditLogService = auditLogService;
    }

    @Override
    public List<InstructorDto> search(String keyword) {
        List<Instructor> instructors;
        if (StringUtils.hasText(keyword)) {
            String value = keyword.trim();
            instructors = instructorRepository
                    .findByInstructorCodeContainingIgnoreCaseOrInstructorNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByInstructorCode(
                            value, value, value);
        } else {
            instructors = instructorRepository.findAllByOrderByInstructorCode();
        }
        return instructors.stream().map(instructorMapper::toDto).toList();
    }

    @Override
    @Transactional
    public InstructorDto create(InstructorDto dto) {
        String code = dto.getInstructorCode().trim().toUpperCase();
        String email = dto.getEmail().trim().toLowerCase();
        if (instructorRepository.existsByInstructorCodeIgnoreCase(code)) {
            throw new BusinessException("Mã giảng viên đã tồn tại: " + code);
        }
        if (instructorRepository.existsByEmailIgnoreCase(email)) {
            throw new BusinessException("Email giảng viên đã tồn tại: " + email);
        }

        Instructor instructor = new Instructor();
        instructor.setInstructorCode(code);
        instructor.setInstructorName(dto.getInstructorName().trim());
        instructor.setInstructorType(dto.getInstructorType());
        instructor.setOrganization(dto.getOrganization());
        instructor.setExpertise(dto.getExpertise());
        instructor.setEmail(email);
        instructor.setPhone(dto.getPhone());
        instructor.setHourlyRate(dto.getHourlyRate());
        instructor.setStatus(dto.getStatus());

        Instructor saved = instructorRepository.save(instructor);
        auditLogService.log("system", "CREATE", "INSTRUCTOR", saved.getId().toString(), null, saved.getInstructorCode());
        return instructorMapper.toDto(saved);
    }
}
