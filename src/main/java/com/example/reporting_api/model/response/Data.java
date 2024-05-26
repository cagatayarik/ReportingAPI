package com.example.reporting_api.model.response;

import java.util.List;

public class Data {
    private List<FX> fx;
    private List<CustomerInfo>  customerInfo;
    private List<MerchantInfo> merchantInfo;
    private List<Boolean> ipn;
    private List<TransactionInfo> transaction;
    private List<AcquirerInfo> acquirerInfo;
    private Boolean refundable;
}
