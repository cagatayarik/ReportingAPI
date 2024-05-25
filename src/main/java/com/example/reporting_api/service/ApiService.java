package com.example.reporting_api.service;

import com.example.reporting_api.model.request.*;
import com.example.reporting_api.model.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Value("${api.login.url}")
    private String loginUrl;

    @Value("${api.report.url}")
    private String reportUrl;

    @Value("${api.query.url}")
    private String queryUrl;

    @Value("${api.transaction.url}")
    private String transactionUrl;

    @Value("${api.client.url}")
    private String clientUrl;

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JwtResponse login(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);

        ResponseEntity<JwtResponse> response = restTemplate.postForEntity(loginUrl, request, JwtResponse.class);
        return response.getBody();
    }

    public TransactionReportResponse getTransactionReport(String token, TransactionReportRequest reportRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<TransactionReportRequest> request = new HttpEntity<>(reportRequest, headers);

        ResponseEntity<TransactionReportResponse> response = restTemplate.exchange(
                reportUrl, HttpMethod.POST, request, TransactionReportResponse.class);

        return response.getBody();
    }

    public TransactionQueryResponse queryTransactions(String token, TransactionQueryRequest queryRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<TransactionQueryRequest> request = new HttpEntity<>(queryRequest, headers);

        ResponseEntity<TransactionQueryResponse> response = restTemplate.exchange(
                queryUrl, HttpMethod.POST, request, TransactionQueryResponse.class);

        return response.getBody();
    }



    public GetTransactionResponse getTransaction(String token, GetTransactionRequest transactionRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<GetTransactionRequest> request = new HttpEntity<>(transactionRequest, headers);

        ResponseEntity<GetTransactionResponse> response = restTemplate.exchange(
                transactionUrl, HttpMethod.POST, request, GetTransactionResponse.class);

        return response.getBody();
    }

    public GetClientResponse getClient(String token, GetClientRequest clientRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<GetClientRequest> request = new HttpEntity<>(clientRequest, headers);

        ResponseEntity<GetClientResponse> response = restTemplate.exchange(
                clientUrl, HttpMethod.POST, request, GetClientResponse.class);

        return response.getBody();
    }
    private static HttpHeaders buildHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
