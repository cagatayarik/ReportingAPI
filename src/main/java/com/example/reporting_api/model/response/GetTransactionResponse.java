package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.CustomerInfoTransactionQuery;
import com.example.reporting_api.model.response.abstracts.TransactionInfoTransactionQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


//Todo: Check this class.
@Getter
@Setter

public class GetTransactionResponse {
    private List<FX> fx;
    private List<CustomerInfoTransactionQuery> customerInfo;
    private List<AcquirerInfo> acquirerInfo;
    private List<MerchantInfo> merchant;
    private List<TransactionInfoTransactionQuery> transaction;

}
