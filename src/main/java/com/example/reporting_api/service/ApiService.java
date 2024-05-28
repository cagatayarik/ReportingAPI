package com.example.reporting_api.service;

import com.example.reporting_api.messages.ErrorMessages;
import com.example.reporting_api.model.enums.Status;
import com.example.reporting_api.model.request.*;
import com.example.reporting_api.model.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
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

    public ResponseEntity<JwtResponse> login(LoginRequest loginRequest) {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);

        ResponseEntity<JwtResponse> response = restTemplate.postForEntity(loginUrl, request, JwtResponse.class);
        JwtResponse jwtResponse = response.getBody();

        if (jwtResponse == null || !(jwtResponse.getStatus().equals(Status.APPROVED.getName())) || jwtResponse.getToken() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, ErrorMessages.LOGIN_ERROR);
        }
        return response;
    }

    public ResponseEntity<TransactionReportResponse> getTransactionReport(String token, TransactionReportRequest reportRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<TransactionReportRequest> request = new HttpEntity<>(reportRequest, headers);

        ResponseEntity<TransactionReportResponse> response = restTemplate.exchange(
                reportUrl, HttpMethod.POST, request, TransactionReportResponse.class);

        TransactionReportResponse transactionReportResponse = response.getBody();

        if(transactionReportResponse == null || !(transactionReportResponse.getStatus().equals(Status.APPROVED.getName()))) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, ErrorMessages.TRANSACTION_ERROR);
        }

        return response;
    }

    public ResponseEntity<TransactionQueryResponse> queryTransactions(String token, TransactionQueryRequest queryRequest) {
        HttpHeaders headers = buildHttpHeaders(token);
        HttpEntity<TransactionQueryRequest> request = new HttpEntity<>(queryRequest, headers);

        try {
            ResponseEntity<TransactionQueryResponse> response = restTemplate.exchange(
                    queryUrl, HttpMethod.POST, request, TransactionQueryResponse.class);

            if (!response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }
            return response;
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }



    public ResponseEntity<GetTransactionResponse> getTransaction(String token, GetTransactionRequest transactionRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<GetTransactionRequest> request = new HttpEntity<>(transactionRequest, headers);
    try{
        ResponseEntity<GetTransactionResponse> response = restTemplate.exchange(
                transactionUrl, HttpMethod.POST, request, GetTransactionResponse.class);
        if(!response.getStatusCode().is2xxSuccessful()){
            throw new HttpClientErrorException(response.getStatusCode(),ErrorMessages.TRANSACTION_ERROR);
        }
        return response;
    }catch(RestClientException e) {
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,ErrorMessages.TRANSACTION_ERROR);
    }



    }

    public ResponseEntity<ClientResponse> getClient(String token, ClientRequest clientRequest) {
        HttpHeaders headers = buildHttpHeaders(token);

        HttpEntity<ClientRequest> request = new HttpEntity<>(clientRequest, headers);

        ResponseEntity<ClientResponse> response = restTemplate.exchange(
                clientUrl, HttpMethod.POST, request, ClientResponse.class);

        return response;
    }
    private static HttpHeaders buildHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
