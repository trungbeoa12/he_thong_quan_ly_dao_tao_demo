package com.example.tms.entity.enums;

public enum AppRole {
    ROLE_ADMIN("ADMIN"),
    ROLE_TRAINING_ADMIN("TRAINING_ADMIN"),
    ROLE_INSTRUCTOR("INSTRUCTOR"),
    ROLE_EMPLOYEE("EMPLOYEE"),
    ROLE_MANAGER("MANAGER");

    private final String displayName;

    AppRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
