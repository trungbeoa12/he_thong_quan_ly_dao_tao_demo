package com.example.tms.entity.enums;

public enum CourseCategory {
    BANKING("Banking"),
    IT("IT"),
    DATA("Data"),
    MANAGEMENT("Management"),
    LEADERSHIP("Leadership"),
    COMPLIANCE("Compliance"),
    SOFT_SKILLS("Soft Skills"),
    RISK_MANAGEMENT("Risk Management"),
    SALES("Sales");

    private final String label;

    CourseCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
