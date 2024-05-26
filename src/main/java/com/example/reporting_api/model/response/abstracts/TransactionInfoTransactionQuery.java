package com.example.reporting_api.model.response.abstracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInfoTransactionQuery {
    private String referenceNo;
    private String status;
    private String operation;
    private String message;
    private String createdAt;
    private String transactionId;

}
