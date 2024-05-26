package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionReportResponse {
    private String status;
    private List<Response> response;

}