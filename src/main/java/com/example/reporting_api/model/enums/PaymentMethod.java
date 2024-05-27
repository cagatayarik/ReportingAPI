package com.example.reporting_api.model.enums;

public enum PaymentMethod {
    CREDITCARD("CREDITCARD"),
    CUP("CUP"),
    IDEAL("IDEAL"),
    GIROPAY("GIROPAY"),
    MISTERCASH("MISTERCASH"),
    STORED("STORED"),
    PAYTOCARD("PAYTOCARD"),
    CEPBANK("CEPBANK"),
    CITADEL("CITADEL"),;

    private final String payment;

    PaymentMethod(String payment) {
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}

