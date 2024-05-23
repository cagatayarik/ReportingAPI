package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClientResponse {
    private CustomerInfo customerInfo;

    @Getter
    @Setter
    public static class CustomerInfo {
        private String email;
        private String billingFirstName;
        private String billingLastName;
        private String billingAddress1;
        private String billingCity;
        private String billingPostcode;
        private String billingCountry;
    }
}
