package com.example.tms.service;

import java.util.List;

import com.example.tms.dto.DepartmentDto;

public interface DepartmentService {

    List<DepartmentDto> search(String keyword);

    List<DepartmentDto> findAll();

    DepartmentDto create(DepartmentDto dto);
}
