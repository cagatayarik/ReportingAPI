package com.example.reporting_api.model.response;

import lombok.Data;

@Data
public class MerchantFXInfo {

    private Double originalAmount;
    private String originalCurrency;
    private Double convertedAmount;
    private String convertedCurrency;
}
