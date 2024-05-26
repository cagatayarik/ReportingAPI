package com.example.reporting_api.model.response;

import lombok.*;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String token;
    private String status;
}
