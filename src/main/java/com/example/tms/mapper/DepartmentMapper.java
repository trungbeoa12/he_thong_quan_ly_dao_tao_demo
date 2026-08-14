package com.example.tms.mapper;

import org.springframework.stereotype.Component;

import com.example.tms.dto.DepartmentDto;
import com.example.tms.entity.Department;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department entity) {
        DepartmentDto dto = new DepartmentDto();
        dto.setId(entity.getId());
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentName(entity.getDepartmentName());
        dto.setDepartmentType(entity.getDepartmentType());
        dto.setStatus(entity.getStatus());
        if (entity.getParentDepartment() != null) {
            dto.setParentDepartmentId(entity.getParentDepartment().getId());
            dto.setParentDepartmentName(entity.getParentDepartment().getDepartmentName());
        }
        return dto;
    }
}
