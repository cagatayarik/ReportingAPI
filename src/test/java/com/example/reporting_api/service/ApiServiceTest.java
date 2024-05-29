package com.example.reporting_api.service;

import com.example.reporting_api.model.request.LoginRequest;
import com.example.reporting_api.model.request.TransactionReportRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiServiceTest {
    @Autowired
    private ApiService apiService;

    @Test
    @Order(1)
    void test_login_success_with_email_and_password() {
        var response = apiService.login(new LoginRequest("demo@financialhouse.io","cjaiU8CV"));
        var body = response.getBody();
        TokenHolder.token = body.getToken();
        assertTrue(!body.getToken().isEmpty());
    }



    static class TokenHolder{
        static String token;
    }
}