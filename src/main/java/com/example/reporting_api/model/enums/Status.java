package com.example.reporting_api.model.enums;

public enum Status {
    APPROVED("APPROVED"),
    WAITING("WAITING"),
    DECLINED("DECLINED"),
    ERROR("ERROR");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
