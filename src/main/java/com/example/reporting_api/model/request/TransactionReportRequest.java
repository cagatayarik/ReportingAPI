package com.example.reporting_api.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionReportRequest {
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date toDate;
    private Integer merchant;
    private Integer acquirer;


    public TransactionReportRequest(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
