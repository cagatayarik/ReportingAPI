package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private Integer count;
    private Integer total;
    private String currency;


}