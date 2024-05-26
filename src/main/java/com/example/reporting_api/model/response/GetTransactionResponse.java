package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


//Todo: Check this class.

@Getter
@Setter
public class GetTransactionResponse {
    private List<FX> fx;
    private List<CustomerInfo> customerInfo;
    private List<AcquirerInfo> acquirerInfo;
    private List<MerchantInfo> merchant;
    private List<TransactionInfo> transaction;

}
