package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.CustomerInfoCommon;
import com.example.reporting_api.model.response.abstracts.TransactionInfoCommon;
import lombok.Data;

@Data

public class GetTransactionResponse {
    private MerchantFX fx;

    private CustomerInfoCommon customerInfo;

    private AcquirerInfo acquirer;

    private MerchantData merchant;

    private TransactionInfoCommon transaction;

    private String updated_at;

    private String created_at;

    private Boolean refundable;

}
