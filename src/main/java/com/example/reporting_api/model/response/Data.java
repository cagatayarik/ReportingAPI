package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.CustomerInfoTransactionQuery;
import com.example.reporting_api.model.response.abstracts.TransactionInfoTransactionQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    private List<FX> fx;
    private List<CustomerInfoTransactionQuery>  customerInfo;
    private List<MerchantInfo> merchantInfo;
    private List<Boolean> ipn;  //TODO Obje yapılabilir mi?
    private List<TransactionInfoTransactionQuery> transaction;
    private List<AcquirerInfo> acquirerInfo;
    private Boolean refundable;
}
