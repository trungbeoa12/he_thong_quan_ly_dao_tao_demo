package com.example.tms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.tms.dto.EmployeeDto;
import com.example.tms.entity.Department;
import com.example.tms.entity.Employee;
import com.example.tms.exception.BusinessException;
import com.example.tms.exception.ResourceNotFoundException;
import com.example.tms.mapper.EmployeeMapper;
import com.example.tms.repository.DepartmentRepository;
import com.example.tms.repository.EmployeeRepository;
import com.example.tms.service.AuditLogService;
import com.example.tms.service.EmployeeService;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;
    private final AuditLogService auditLogService;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            EmployeeMapper employeeMapper,
            AuditLogService auditLogService) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
        this.auditLogService = auditLogService;
    }

    @Override
    public List<EmployeeDto> search(String keyword) {
        List<Employee> employees;
        if (StringUtils.hasText(keyword)) {
            String value = keyword.trim();
            employees = employeeRepository
                    .findByEmployeeCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByEmployeeCode(
                            value, value, value);
        } else {
            employees = employeeRepository.findAllByOrderByEmployeeCode();
        }
        return employees.stream().map(employeeMapper::toDto).toList();
    }

    @Override
    @Transactional
    public EmployeeDto create(EmployeeDto dto) {
        String code = dto.getEmployeeCode().trim().toUpperCase();
        String email = dto.getEmail().trim().toLowerCase();
        if (employeeRepository.existsByEmployeeCodeIgnoreCase(code)) {
            throw new BusinessException("Mã nhân viên đã tồn tại: " + code);
        }
        if (employeeRepository.existsByEmailIgnoreCase(email)) {
            throw new BusinessException("Email nhân viên đã tồn tại: " + email);
        }

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng ban của nhân viên"));

        Employee employee = new Employee();
        employee.setEmployeeCode(code);
        employee.setFullName(dto.getFullName().trim());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setGender(dto.getGender());
        employee.setEmail(email);
        employee.setPhone(dto.getPhone());
        employee.setDepartment(department);
        employee.setPosition(dto.getPosition());
        employee.setJobTitle(dto.getJobTitle());
        employee.setHireDate(dto.getHireDate());
        employee.setEmployeeLevel(dto.getEmployeeLevel());
        employee.setRegion(dto.getRegion());
        employee.setGenerationGroup(dto.getGenerationGroup());
        employee.setSalaryGroup(dto.getSalaryGroup());
        employee.setStatus(dto.getStatus());

        Employee saved = employeeRepository.save(employee);
        auditLogService.log("system", "CREATE", "EMPLOYEE", saved.getId().toString(), null, saved.getEmployeeCode());
        return employeeMapper.toDto(saved);
    }
}
