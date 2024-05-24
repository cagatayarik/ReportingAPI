package com.example.reporting_api.controller;

import com.example.reporting_api.model.request.*;
import com.example.reporting_api.model.response.*;
import com.example.reporting_api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/merchant/user/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        return apiService.login(loginRequest);
    }

    @PostMapping("/transactions/report")
    public TransactionReportResponse getTransactionReport(@RequestHeader("Authorization") String token,
                                                          @RequestBody TransactionReportRequest reportRequest) {
        return apiService.getTransactionReport(token, reportRequest);
    }

    @PostMapping("/transaction/list")
    public TransactionQueryResponse queryTransactions(@RequestHeader("Authorization") String token, @RequestBody TransactionQueryRequest queryRequest) {
        return apiService.queryTransactions(token, queryRequest);
    }

    @PostMapping("/transaction")
    public GetTransactionResponse getTransaction(@RequestHeader("Authorization") String token, @RequestBody GetTransactionRequest transactionRequest) {
        return apiService.getTransaction(token, transactionRequest);
    }

    @PostMapping("/client")
    public GetClientResponse getClient(@RequestHeader("Authorization") String token, @RequestBody GetClientRequest clientRequest) {
        return apiService.getClient(token, clientRequest);
    }
}
