package com.example.reporting_api.controller;


import com.example.reporting_api.model.request.*;
import com.example.reporting_api.model.response.*;
import com.example.reporting_api.service.ApiService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/merchant/user/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return apiService.login(loginRequest);
    }

    @PostMapping("/transactions/report")
    public ResponseEntity<TransactionReportResponse> getTransactionReport(@RequestHeader(value = "authorization") @NotNull String authorization,
                                                                          @RequestBody @Valid TransactionReportRequest reportRequest) {
        return apiService.getTransactionReport(authorization, reportRequest);
    }

    @PostMapping("/transaction/list")
    public ResponseEntity<TransactionQueryResponse> queryTransactions(@RequestHeader(value = "authorization") @NotNull String authorization,
                                                                      @RequestBody @Valid TransactionQueryRequest queryRequest) {
        return apiService.queryTransactions(authorization, queryRequest);
    }

    @PostMapping("/transaction")
    public ResponseEntity<GetTransactionResponse> getTransaction(@RequestHeader(value = "authorization") @NotNull String authorization,
                                                                 @RequestBody @Valid GetTransactionRequest transactionRequest) {
        return apiService.getTransaction(authorization, transactionRequest);
    }

    @PostMapping("/client")
    public ResponseEntity<ClientResponse> getClient(@RequestHeader(value = "authorization") @NotNull String authorization,
                                                    @RequestBody @Valid ClientRequest clientRequest) {
        return apiService.getClient(authorization, clientRequest);
    }
}
