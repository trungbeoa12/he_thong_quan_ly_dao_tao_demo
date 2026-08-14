package com.example.tms.dto;

import java.util.List;

public record UserAccountDto(
        String username,
        boolean enabled,
        List<String> roles) {
}
