package com.example.tms.entity.enums;

public enum TrainingMethod {
    OFFLINE("Offline"),
    ONLINE("Online"),
    E_LEARNING("E-Learning"),
    BLENDED("Blended");

    private final String label;

    TrainingMethod(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
