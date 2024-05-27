package com.example.reporting_api.model.response;

import lombok.Data;

@Data
public class Agent {
    private Integer id;
    private String customerIp;
    private String customerUserAgent;
    private String merchantIp;
}
