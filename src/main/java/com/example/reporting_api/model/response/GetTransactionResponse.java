package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.CustomerInfoCommon;
import com.example.reporting_api.model.response.abstracts.TransactionInfoCommon;
import lombok.Data;
import java.util.List;


@Data

public class GetTransactionResponse {
    private List<FX> fx;
    private List<CustomerInfoCommon> customerInfo;
    private List<AcquirerInfo> acquirerInfo;
    private List<MerchantData> merchant;
    private List<TransactionInfoCommon> transaction;

}
