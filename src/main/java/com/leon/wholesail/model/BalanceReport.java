package com.leon.wholesail.model;

import com.leon.wholesail.utils.BalanceReportItemUtil;
import lombok.Data;

import java.util.*;

@Data
public class BalanceReport {
    Map<String, BalanceReportItem> items = new HashMap<>();

    public Optional<BalanceReportItem> identifyItem(String customerId) {
        if (!items.containsKey(customerId)) {
            return Optional.empty();
        }
        return Optional.of(items.get(customerId));
    }

    public void appendInvoiceList(List<Invoice> invoiceList) {
        if (invoiceList != null && !invoiceList.isEmpty()) {
            for (Invoice invoice : invoiceList) {
                appendInvoice(invoice);
            }
        }
    }


    public void appendInvoice(Invoice invoice) {
        Optional<BalanceReportItem> itemOptional = identifyItem(invoice.getCustomerId());
        BalanceReportItem balanceReportItem;
        if (!itemOptional.isPresent()) {
            balanceReportItem = new BalanceReportItem(invoice.getCustomerId());
        } else {
            balanceReportItem = itemOptional.get();
        }
        BalanceReportItemUtil.calculateOutstandingBalance(invoice, balanceReportItem);
        BalanceReportItemUtil.calculatePastDueBalance(invoice, balanceReportItem);

        if (!itemOptional.isPresent()) {
            items.put(balanceReportItem.getCustomer(), balanceReportItem);
        }
    }


    public void balanceReportToString() {
        System.out.println(String.format("%s | %s | %s",
                "CustomerName",
                "OutstandingBalance",
                "PastDueBalance"));
        for (BalanceReportItem item : items.values()) {
            System.out.println(String.format("%s|      %s           |      %s      ",
                    item.getCustomer(),
                    item.getOutstandingBalance().toString(),
                    item.getPastDueBalance().toString()));
        }

    }


}
