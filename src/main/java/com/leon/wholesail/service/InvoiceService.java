package com.leon.wholesail.service;


import com.leon.wholesail.model.BalanceReport;
import com.leon.wholesail.model.Invoice;
import com.leon.wholesail.utils.DataParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {


    public void handleInvoice() throws IOException, ParseException, NoSuchFieldException, IllegalAccessException {
        Invoice invoice1 = new Invoice();
        invoice1.setInvoiceId("1");
        invoice1.setTransactionAmount(BigDecimal.valueOf(100));
        invoice1.setAdjustmentAmount(BigDecimal.valueOf(20));
        invoice1.setPaidAmount(BigDecimal.valueOf(2));
        invoice1.setPaymentTerm(10);
        invoice1.setCustomerId("Customer Leon");
        invoice1.setCreatedDate(new Date());

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId("2");
        invoice2.setTransactionAmount(BigDecimal.valueOf(200));
        invoice2.setAdjustmentAmount(BigDecimal.valueOf(5));
        invoice2.setPaidAmount(BigDecimal.valueOf(0));
        invoice2.setPaymentTerm(10);
        invoice2.setCustomerId("Customer Leon");
        invoice2.setCreatedDate(new Date());


//        Resource resource = new ClassPathResource("inputs/data-golden-gate-produce-10.csv");
        Resource resource = new ClassPathResource("inputs/data-happy-fruits-10.csv");
        List<Invoice> invoiceList = DataParser.parseData("customer-2",
                resource.getInputStream());


        BalanceReport balanceReport = new BalanceReport();
        balanceReport.appendInvoiceList(invoiceList);
//        balanceReport.appendInvoice(invoice1);
//        balanceReport.appendInvoice(invoice2);
        balanceReport.balanceReportToString();
    }

    public static void main(String[] args) throws IOException, ParseException, NoSuchFieldException, IllegalAccessException {
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.handleInvoice();
    }
}
