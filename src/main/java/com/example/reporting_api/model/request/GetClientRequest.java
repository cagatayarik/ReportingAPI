package com.example.reporting_api.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClientRequest {
    @NotNull
    @Size(max =32,message = "This field can not be over 32 characters")
    private String transactionId;
}
