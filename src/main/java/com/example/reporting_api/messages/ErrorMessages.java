package com.example.reporting_api.messages;

public class ErrorMessages {
    private ErrorMessages (){}
    public static final String LOGIN_ERROR = "Login request is not approved";
    public static final String TRANSACTION_ERROR = "Transaction request is not approved";
    public static final String STATUS_ERROR = "Please enter correct status code";
    public static final String PAYMENT_METHOD_ERROR = "Please enter valid payment method";
    public static final String TRANSACTION_LIST_ERROR = "Can not list transactions";

}
