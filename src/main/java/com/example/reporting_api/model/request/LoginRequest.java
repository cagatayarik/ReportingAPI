package com.example.reporting_api.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    @Valid
    @Size(max = 128,message ="This field can not be over 128 characters" )
    private String email;

    @NotNull
    @Valid
    @Size(max = 32, message = "This field can not be over 32 characters")
    private String password;


}
