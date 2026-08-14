package com.example.tms.mapper;

import org.springframework.stereotype.Component;

import com.example.tms.dto.EmployeeDto;
import com.example.tms.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setEmployeeCode(entity.getEmployeeCode());
        dto.setFullName(entity.getFullName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setGender(entity.getGender());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setPosition(entity.getPosition());
        dto.setJobTitle(entity.getJobTitle());
        dto.setHireDate(entity.getHireDate());
        dto.setEmployeeLevel(entity.getEmployeeLevel());
        dto.setRegion(entity.getRegion());
        dto.setGenerationGroup(entity.getGenerationGroup());
        dto.setSalaryGroup(entity.getSalaryGroup());
        dto.setStatus(entity.getStatus());
        if (entity.getDepartment() != null) {
            dto.setDepartmentId(entity.getDepartment().getId());
            dto.setDepartmentName(entity.getDepartment().getDepartmentName());
        }
        return dto;
    }
}
