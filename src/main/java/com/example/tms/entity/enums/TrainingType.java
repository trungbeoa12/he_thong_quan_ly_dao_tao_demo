package com.example.tms.entity.enums;

public enum TrainingType {
    INTERNAL("Nội bộ"),
    EXTERNAL("Bên ngoài");

    private final String label;

    TrainingType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
