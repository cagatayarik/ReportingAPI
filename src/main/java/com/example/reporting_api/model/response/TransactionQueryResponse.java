package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TransactionQueryResponse {
    private Integer per_page;
    private Integer current_page;
    private String next_page_url;
    private String prev_page_url;
    private Integer from;
    private Integer to;
    private List<Data> data;

    }


