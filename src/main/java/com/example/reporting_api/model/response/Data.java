package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.CustomerInfoCommon;
import com.example.reporting_api.model.response.abstracts.TransactionInfoCommon;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
public class Data {

    private List<MerchantFX> fx;

    private List<CustomerInfoCommon>  customerInfo;

    private List<MerchantData> merchantInfo;

    private List<Boolean> ipn;

    private List<TransactionInfoCommon> transaction;

    private List<AcquirerInfo> acquirerInfo;

    private Boolean refundable;
}
