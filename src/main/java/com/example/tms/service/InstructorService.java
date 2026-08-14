package com.example.tms.service;

import java.util.List;

import com.example.tms.dto.InstructorDto;

public interface InstructorService {

    List<InstructorDto> search(String keyword);

    InstructorDto create(InstructorDto dto);
}
