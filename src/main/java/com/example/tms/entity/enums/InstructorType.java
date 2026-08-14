package com.example.tms.entity.enums;

public enum InstructorType {
    INTERNAL("Nội bộ"),
    EXTERNAL("Bên ngoài");

    private final String label;

    InstructorType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
