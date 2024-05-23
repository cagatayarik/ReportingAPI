package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class TransactionQueryResponse {
    private int per_page;
    private int current_page;
    private String next_page_url;
    private String prev_page_url;
    private int from;
    private int to;
    private List<Transaction> data;

    @Getter
    @Setter
    public static class Transaction {
        private FX fx;
        private CustomerInfo customerInfo;
        private Merchant merchant;
        private Ipn ipn;
        private TransactionInfo transaction;
        private Acquirer acquirer;
        private boolean refundable;

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

        }

        @Getter
        @Setter
        public static class Merchant {
            private int id;
            private String name;
        }

        @Getter
        @Setter
        public static class Ipn {
            private boolean received;

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
        @Getter
        @Setter

        public static class Acquirer {
            private int id;
            private String name;
            private String code;
            private String type;

        }

    }
}

