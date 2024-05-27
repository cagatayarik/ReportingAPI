package com.example.reporting_api.model.enums;

public enum Operation {
    DIRECT,
    REFUND,
    THREE_D("3D"),
    THREE_D_AUTH("3DAUTH"),
    STORED;

    private final String value;

    Operation() {
        this.value = name();
    }

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

