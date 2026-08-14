package com.example.tms.service;

import java.util.List;

import com.example.tms.dto.EmployeeDto;

public interface EmployeeService {

    List<EmployeeDto> search(String keyword);

    EmployeeDto create(EmployeeDto dto);
}
