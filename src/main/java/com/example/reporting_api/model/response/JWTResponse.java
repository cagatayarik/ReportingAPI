package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTResponse {
    private String token;
    private String status;
}
