package com.example.tms.entity.enums;

public enum DepartmentType {
    HEAD_OFFICE("Head Office"),
    DIVISION("Khối"),
    BRANCH("Chi nhánh"),
    DEPARTMENT("Phòng ban"),
    TEAM("Nhóm");

    private final String label;

    DepartmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
