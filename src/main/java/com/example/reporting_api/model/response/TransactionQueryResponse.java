package com.example.reporting_api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TransactionQueryResponse {
    private Long current_page;

    private String first_page_url;

    private Long from;

    private String next_page_url;

    private String path;

    private Long per_page;

    private String prev_page_url;

    private Long to;

    private List<GetTransactionResponse> data;

    }


