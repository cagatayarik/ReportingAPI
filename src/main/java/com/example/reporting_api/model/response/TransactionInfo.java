package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInfo {
    private String referenceNo;
    private String status;
    private String operation;
    private String message;
    private String createdAt;
    private String transactionId;

}
