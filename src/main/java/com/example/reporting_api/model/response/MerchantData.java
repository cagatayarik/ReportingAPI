package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.MerchantInfoCommon;
import lombok.Data;


@Data
public class MerchantData extends MerchantInfoCommon {
    private Long id;
    private String name;
    private Boolean allowPartialRefund;
    private Boolean allowPartialCapture;
}