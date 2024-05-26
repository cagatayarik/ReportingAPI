package com.example.reporting_api.controller;

import com.example.reporting_api.model.request.TransactionReportRequest;
import com.example.reporting_api.model.response.TransactionReportResponse;
import com.example.reporting_api.service.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTransactionReportTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;
    private final String authorizationToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNCwxMzMxLDEzMzgsMTMzOSwxMzQxLDEzNDYsMTM0NywxMzQ4LDEzNDksMTM1MywxMzgzLDEzODQsMTM4NV0sInRpbWVzdGFtcCI6MTcxNjc0MTc0Nn0.TD13hCAM044TEPV6E5fYDweIstM4MIm5NyqKhcjM7GA";

    @Test
    public void testGetTransactionReport() throws Exception {
        TransactionReportRequest request = new TransactionReportRequest();
        request.setFromDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01"));
        request.setToDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-31"));
        request.setMerchant(123);
        request.setAcquirer(456);

        TransactionReportResponse response = new TransactionReportResponse();
        response.setStatus("success");
        response.setResponse(Collections.emptyList());

        Mockito.when(apiService.getTransactionReport(authorizationToken, request)).thenReturn(response);

        mockMvc.perform(post("/api/v3//transactions/report")
                        .header("authorization", authorizationToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("APPROVED"))
                .andExpect(jsonPath("$.response").isEmpty());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
