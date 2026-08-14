package com.example.tms.entity.enums;

public enum RecordStatus {
    ACTIVE("Hoạt động"),
    INACTIVE("Ngừng hoạt động");

    private final String label;

    RecordStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
