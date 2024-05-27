package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.MerchantInfoCommon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantData extends MerchantInfoCommon {
    private String name;
}