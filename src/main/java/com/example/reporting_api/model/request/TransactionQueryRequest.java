package com.example.reporting_api.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionQueryRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date toDate;

    @Size(max =64,message = "This field can not be over 64 characters")
    private String status;

    @Size(max =64,message = "This field can not be over 64 characters")
    private String operation;

    private Integer merchantId;

    private Integer acquirerId;

    @Size(max =32,message = "This field can not be over 32 characters")
    private String paymentMethod;

    @Size(max =256,message = "This field can not be over 256 characters")
    private String errorCode;

    @Size(max =128,message = "This field can not be over 128 characters")
    private String filterField;

    @Size(max =256,message = "This field can not be over 256 characters")
    private String filterValue;

    private Integer page;
}
