package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.CustomerInfoCommon;
import com.example.reporting_api.model.response.abstracts.TransactionInfoCommon;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import java.util.List;


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
