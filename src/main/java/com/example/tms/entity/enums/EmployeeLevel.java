package com.example.tms.entity.enums;

public enum EmployeeLevel {
    STAFF("Nhân viên"),
    SENIOR_STAFF("Nhân viên chính"),
    SPECIALIST("Chuyên viên"),
    MANAGER("Quản lý"),
    SENIOR_MANAGER("Quản lý cấp cao"),
    DIRECTOR("Giám đốc");

    private final String label;

    EmployeeLevel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
