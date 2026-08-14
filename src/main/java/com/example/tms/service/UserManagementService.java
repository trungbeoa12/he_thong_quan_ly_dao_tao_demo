package com.example.tms.service;

import java.util.List;

import com.example.tms.dto.UserAccountDto;
import com.example.tms.dto.UserCreateDto;

public interface UserManagementService {

    List<UserAccountDto> findAll();

    UserAccountDto create(UserCreateDto dto);
}
