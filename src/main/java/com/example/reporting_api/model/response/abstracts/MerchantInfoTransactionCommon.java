package com.example.reporting_api.model.response.abstracts;

import com.example.reporting_api.model.response.Agent;
import lombok.Data;

@Data
public class MerchantInfoTransactionCommon {

    private String referenceNo;

    private String status;

    private String customData;

    private String type;

    private String operation;

    private String createdAt;

    private String message;

    private String transactionId;

    private Agent agent;
}
