package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionReportResponse {
    private String status;
    private List<Response> response;


    @Getter
    @Setter
    public static class Response {
        private int count;
        private int total;
        private String currency;


    }
}