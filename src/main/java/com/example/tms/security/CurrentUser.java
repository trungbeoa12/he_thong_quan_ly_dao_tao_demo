package com.example.tms.security;

import java.util.Set;

public record CurrentUser(
        String username,
        Set<String> roles) {
}
