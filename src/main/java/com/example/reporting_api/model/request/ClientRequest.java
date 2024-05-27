package com.example.reporting_api.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ClientRequest {
    @NotNull
    @Size(max =32,message = "This field can not be over 32 characters")
    private String transactionId;
}
