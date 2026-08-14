package com.example.tms.controller;

import java.util.List;

import com.example.tms.dto.EmployeeDto;
import com.example.tms.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','TRAINING_ADMIN','MANAGER')")
public class EmployeeApiController {

    private final EmployeeService employeeService;

    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<EmployeeDto> list(@RequestParam(defaultValue = "") String keyword) {
        return employeeService.search(keyword);
    }
}
