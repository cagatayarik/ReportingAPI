package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String status;

    public JwtResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }
}
