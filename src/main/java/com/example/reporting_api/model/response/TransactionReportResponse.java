package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionReportResponse {
    private String status;
    private int count;
    private int total;
    private String currency;

}
