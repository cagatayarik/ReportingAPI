package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetClientResponse {
    private List<CustomerInfo> customerInfo;


}
