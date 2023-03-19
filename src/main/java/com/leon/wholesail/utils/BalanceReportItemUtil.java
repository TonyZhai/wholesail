package com.leon.wholesail.utils;

import com.leon.wholesail.model.BalanceReportItem;
import com.leon.wholesail.model.Invoice;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.Date;

public class BalanceReportItemUtil {
    public static final MathContext MATH_CONTEXT_USD = new MathContext(2);
    public static final LocalDateTime CURRENT_DATE = LocalDateTime.of(2022, 3, 31, 0, 0, 0);

    public static boolean hasPastDue(Date date, Integer termSchedule, LocalDateTime currentDate) {
        Date due = DateUtils.addDays(date, termSchedule);
        LocalDateTime dueDate = DateUtil.asLocalDateTime(due);
        return dueDate.isBefore(currentDate);
    }

    public static void calculatePastDueBalance(Invoice invoice, BalanceReportItem balanceReportItem) {
        if (hasPastDue(invoice.getCreatedDate(), invoice.getPaymentTerm(), CURRENT_DATE)) {
            BigDecimal appendBalance = invoice.getTransactionAmount().add(invoice.getAdjustmentAmount()).subtract(invoice.getPaidAmount());
            BigDecimal newPastDueBalance = balanceReportItem.getPastDueBalance().add(appendBalance);
            balanceReportItem.setPastDueBalance(newPastDueBalance);
        }
    }

    public static void calculateOutstandingBalance(Invoice invoice, BalanceReportItem balanceReportItem) {
        BigDecimal appendBalance = invoice.getTransactionAmount().add(invoice.getAdjustmentAmount()).subtract(invoice.getPaidAmount());
        BigDecimal newBalance = balanceReportItem.getOutstandingBalance().add(appendBalance);
        balanceReportItem.setOutstandingBalance(newBalance);
    }
}
