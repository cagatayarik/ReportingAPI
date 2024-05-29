package com.example.reporting_api.model.response;

import com.example.reporting_api.model.response.abstracts.MerchantInfoTransactionCommon;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MerchantTransactionDetail extends MerchantInfoTransactionCommon {

    private Integer merchantId;

    private String channel;

    private String customData;

    private String chainId;

    private Integer agentInfoId;

    private Integer fxTransactionId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    private Integer id;

    private Integer acquirerTransactionId;

    private String code;

}
