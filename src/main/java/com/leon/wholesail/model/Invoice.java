package com.leon.wholesail.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Invoice {

    String invoiceId;

    String customerId;

    BigDecimal transactionAmount;

    Date createdDate;

    BigDecimal adjustmentAmount;

    Integer paymentTerm;

    String invoiceItems;

    String billingAddress;

    String shippingAddress;

    Date paidDate;

    BigDecimal paidAmount;

    String description;

}
