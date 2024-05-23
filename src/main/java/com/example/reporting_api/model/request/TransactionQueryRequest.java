package com.example.reporting_api.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionQueryRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date toDate;
    private String status;
    private String operation;
    private int merchantId;
    private int acquirerId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private int page;
}
