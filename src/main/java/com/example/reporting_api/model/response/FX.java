package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Currency;
@Getter
@Setter
public class FX {
    private Double originalAmount;
    private String originalCurrency;

}