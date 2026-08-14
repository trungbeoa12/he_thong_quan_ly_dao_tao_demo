package com.example.tms.mapper;

import org.springframework.stereotype.Component;

import com.example.tms.dto.InstructorDto;
import com.example.tms.entity.Instructor;

@Component
public class InstructorMapper {

    public InstructorDto toDto(Instructor entity) {
        InstructorDto dto = new InstructorDto();
        dto.setId(entity.getId());
        dto.setInstructorCode(entity.getInstructorCode());
        dto.setInstructorName(entity.getInstructorName());
        dto.setInstructorType(entity.getInstructorType());
        dto.setOrganization(entity.getOrganization());
        dto.setExpertise(entity.getExpertise());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setHourlyRate(entity.getHourlyRate());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
