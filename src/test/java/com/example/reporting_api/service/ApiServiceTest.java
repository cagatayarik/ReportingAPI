package com.example.reporting_api.service;

import com.example.reporting_api.model.request.LoginRequest;
import com.example.reporting_api.model.request.TransactionReportRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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

    @Test
    @Order(2)
    void test_login_failed_with_email() {
        var response = apiService.login(new LoginRequest("asdfasdfasd","cjaiU8CV"));
        var body = response.getBody();
        TokenHolder.token = body.getToken();
        assertFalse(!body.getToken().isEmpty());
    }

    @Test
    @Order(3)
    void getTransactionReport() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date fromDate = null;
        try {
            fromDate = format.parse("2010-07-01");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date toDate = null;
        try {
            toDate = format.parse("2023-10-01");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        var response = apiService.getTransactionReport(TokenHolder.token, new TransactionReportRequest(fromDate,toDate));
        var body = response.getBody();
        assertTrue(body.getResponse().size() == 4);
    }

    @Test
    @Order(3)
    void queryTransactions() {
    }

    @Test
    @Order(4)
    void getTransaction() {
    }

    @Test
    @Order(5)
    void getClient() {
    }

    static class TokenHolder{
        static String token;
    }
}