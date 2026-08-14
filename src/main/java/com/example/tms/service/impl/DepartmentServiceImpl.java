package com.example.tms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.tms.dto.DepartmentDto;
import com.example.tms.entity.Department;
import com.example.tms.exception.BusinessException;
import com.example.tms.exception.ResourceNotFoundException;
import com.example.tms.mapper.DepartmentMapper;
import com.example.tms.repository.DepartmentRepository;
import com.example.tms.service.AuditLogService;
import com.example.tms.service.DepartmentService;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final AuditLogService auditLogService;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository,
            DepartmentMapper departmentMapper,
            AuditLogService auditLogService) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.auditLogService = auditLogService;
    }

    @Override
    public List<DepartmentDto> search(String keyword) {
        List<Department> departments;
        if (StringUtils.hasText(keyword)) {
            departments = departmentRepository
                    .findByDepartmentNameContainingIgnoreCaseOrDepartmentCodeContainingIgnoreCaseOrderByDepartmentCode(
                            keyword.trim(), keyword.trim());
        } else {
            departments = departmentRepository.findAllByOrderByDepartmentCode();
        }
        return departments.stream().map(departmentMapper::toDto).toList();
    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentRepository.findAllByOrderByDepartmentCode().stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public DepartmentDto create(DepartmentDto dto) {
        String code = dto.getDepartmentCode().trim().toUpperCase();
        if (departmentRepository.existsByDepartmentCodeIgnoreCase(code)) {
            throw new BusinessException("Mã phòng ban đã tồn tại: " + code);
        }

        Department department = new Department();
        department.setDepartmentCode(code);
        department.setDepartmentName(dto.getDepartmentName().trim());
        department.setDepartmentType(dto.getDepartmentType());
        department.setStatus(dto.getStatus());
        if (dto.getParentDepartmentId() != null) {
            Department parent = departmentRepository.findById(dto.getParentDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng ban cha"));
            department.setParentDepartment(parent);
        }

        Department saved = departmentRepository.save(department);
        auditLogService.log("system", "CREATE", "DEPARTMENT", saved.getId().toString(), null, saved.getDepartmentCode());
        return departmentMapper.toDto(saved);
    }
}
