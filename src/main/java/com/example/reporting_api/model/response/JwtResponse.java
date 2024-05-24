package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;


public class JwtResponse {
    private String token;
    private String status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
