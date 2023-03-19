package com.leon.wholesail.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceReportItem {

    public BalanceReportItem(String customer) {
        this.customer = customer;
        this.OutstandingBalance = BigDecimal.ZERO;
        this.PastDueBalance = BigDecimal.ZERO;
    }

    String customer;

    BigDecimal OutstandingBalance;

    BigDecimal PastDueBalance;
}
