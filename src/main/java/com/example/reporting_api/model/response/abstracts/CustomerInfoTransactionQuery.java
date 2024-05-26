package com.example.reporting_api.model.response.abstracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInfoTransactionQuery {

    private String number;
    private String email;
    private String billingFirstName;
    private String billingLastName;



}
