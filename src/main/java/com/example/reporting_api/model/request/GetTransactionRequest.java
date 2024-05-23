package com.example.reporting_api.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTransactionRequest {
    private String transactionId;
}
