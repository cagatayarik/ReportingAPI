package com.example.reporting_api.model.response.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MerchantInfoTransactionCommon {

    private String referenceNo;
    private String status;
    private String operation;
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    private String transactionId;
}
