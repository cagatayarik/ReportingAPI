package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTransactionResponse {
    private FX fx;
    private CustomerInfo customerInfo;
    private MerchantInfo merchant;
    private TransactionInfo transaction;


    @Getter
    @Setter
    public static class FX {
        private double originalAmount;
        private String originalCurrency;

    }
    @Getter
    @Setter
    public static class CustomerInfo {
        private String email;
        private String billingFirstName;
        private String billingLastName;
        private String billingAddress1;
        private String billingCity;
        private String billingPostcode;
        private String billingCountry;
    }
    @Getter
    @Setter
    public static class MerchantInfo {
        private String name;
    }

    @Getter
    @Setter
    public static class TransactionInfo {
        private String referenceNo;
        private String status;
        private String operation;
        private String message;
        private String createdAt;
        private String transactionId;
    }
}
