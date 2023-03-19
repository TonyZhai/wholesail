package com.leon.wholesail.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Customer {
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    String customerName;

}
