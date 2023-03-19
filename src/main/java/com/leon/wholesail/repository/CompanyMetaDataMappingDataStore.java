package com.leon.wholesail.repository;

import com.leon.wholesail.enums.AmountUnit;
import com.leon.wholesail.enums.FieldType;
import com.leon.wholesail.metadata.CompanyDataMappingInfo;
import com.leon.wholesail.metadata.MappingFieldMetadata;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CompanyMetaDataMappingDataStore {

    private static Map<String, CompanyDataMappingInfo> companyMetaDataMap = new ConcurrentHashMap<>();

    static {
        Map<String, MappingFieldMetadata> goldenGate = new HashMap<>();
        MappingFieldMetadata goldenGateField1 = new MappingFieldMetadata();
        String fieldName1 = "id";
        goldenGateField1.setFieldName(fieldName1);
        goldenGateField1.setFieldPosition(0);
        goldenGateField1.setFieldType(FieldType.STRING);
        goldenGateField1.setTargetFieldName("invoiceId");
        goldenGate.put(fieldName1, goldenGateField1);

        MappingFieldMetadata goldenGateField2 = new MappingFieldMetadata();
        String fieldName2 = "customer";
        goldenGateField2.setFieldName(fieldName2);
        goldenGateField2.setFieldPosition(1);
        goldenGateField2.setFieldType(FieldType.STRING);
        goldenGateField2.setTargetFieldName("customerId");
        goldenGate.put(fieldName2, goldenGateField2);

        MappingFieldMetadata goldenGateField3 = new MappingFieldMetadata();
        String fieldName3 = "amount";
        goldenGateField3.setFieldName(fieldName3);
        goldenGateField3.setFieldPosition(2);
        goldenGateField3.setFieldType(FieldType.DECIMAL);
        goldenGateField3.setTargetFieldName("transactionAmount");
        goldenGate.put(fieldName3, goldenGateField3);

        MappingFieldMetadata goldenGateField4 = new MappingFieldMetadata();
        String fieldName4 = "date";
        goldenGateField4.setFieldName(fieldName4);
        goldenGateField4.setFieldPosition(3);
        goldenGateField4.setFieldType(FieldType.DATE);
        goldenGateField4.setTargetFieldName("createdDate");
        goldenGate.put(fieldName4, goldenGateField4);

        MappingFieldMetadata goldenGateField5 = new MappingFieldMetadata();
        String fieldName5 = "adjustment";
        goldenGateField5.setFieldName(fieldName5);
        goldenGateField5.setFieldPosition(4);
        goldenGateField5.setFieldType(FieldType.DECIMAL);
        goldenGateField5.setTargetFieldName("adjustmentAmount");
        goldenGate.put(fieldName5, goldenGateField5);

        MappingFieldMetadata goldenGateField6 = new MappingFieldMetadata();
        String fieldName6 = "term_schedule";
        goldenGateField6.setFieldName(fieldName6);
        goldenGateField6.setFieldPosition(5);
        goldenGateField6.setFieldType(FieldType.INTEGER);
        goldenGateField6.setTargetFieldName("paymentTerm");
        goldenGate.put(fieldName6, goldenGateField6);

        MappingFieldMetadata goldenGateField7 = new MappingFieldMetadata();
        String fieldName7 = "items";
        goldenGateField7.setFieldName(fieldName7);
        goldenGateField7.setFieldPosition(6);
        goldenGateField7.setFieldType(FieldType.JSON);
        goldenGateField7.setTargetFieldName("invoiceItems");
        goldenGate.put(fieldName7, goldenGateField7);

        MappingFieldMetadata goldenGateField8 = new MappingFieldMetadata();
        String fieldName8 = "billing_address";
        goldenGateField8.setFieldName(fieldName7);
        goldenGateField8.setFieldPosition(7);
        goldenGateField8.setFieldType(FieldType.STRING);
        goldenGateField8.setTargetFieldName("billingAddress");
        goldenGate.put(fieldName8, goldenGateField8);

        MappingFieldMetadata goldenGateField9 = new MappingFieldMetadata();
        String fieldName9 = "shipping_address";
        goldenGateField9.setFieldName(fieldName9);
        goldenGateField9.setFieldPosition(8);
        goldenGateField9.setFieldType(FieldType.STRING);
        goldenGateField9.setTargetFieldName("shippingAddress");
        goldenGate.put(fieldName9, goldenGateField9);

        MappingFieldMetadata goldenGateField10 = new MappingFieldMetadata();
        String fieldName10 = "paid_at";
        goldenGateField10.setFieldName(fieldName10);
        goldenGateField10.setFieldPosition(9);
        goldenGateField10.setFieldType(FieldType.DATE);
        goldenGateField10.setTargetFieldName("paidDate");
        goldenGate.put(fieldName10, goldenGateField10);

        MappingFieldMetadata goldenGateField11 = new MappingFieldMetadata();
        String fieldName11 = "paid_amount";
        goldenGateField11.setFieldName(fieldName11);
        goldenGateField11.setFieldPosition(10);
        goldenGateField11.setFieldType(FieldType.DECIMAL);
        goldenGateField11.setTargetFieldName("paidAmount");
        goldenGate.put(fieldName11, goldenGateField11);

        MappingFieldMetadata goldenGateField12 = new MappingFieldMetadata();
        String fieldName12 = "note";
        goldenGateField12.setFieldName(fieldName12);
        goldenGateField12.setFieldPosition(11);
        goldenGateField12.setFieldType(FieldType.STRING);
        goldenGateField12.setTargetFieldName("description");
        goldenGate.put(fieldName12, goldenGateField12);

        companyMetaDataMap.put("customer-1",
                new CompanyDataMappingInfo("customer-1", "Golden Gate", "yyyy-MM-dd",
                        AmountUnit.DOLLAR, goldenGate));




        Map<String, MappingFieldMetadata> happyFruits = new HashMap<>();
        MappingFieldMetadata happyFruits1 = new MappingFieldMetadata();
        String happyFruitsFieldName1 = "invoiceid";
        happyFruits1.setFieldName(happyFruitsFieldName1);
        happyFruits1.setFieldPosition(0);
        happyFruits1.setFieldType(FieldType.STRING);
        happyFruits1.setTargetFieldName("invoiceId");
        happyFruits.put(happyFruitsFieldName1, happyFruits1);

        MappingFieldMetadata happyFruits2 = new MappingFieldMetadata();
        String happyFruitsFieldName2 = "transAmountCents";
        happyFruits2.setFieldName(happyFruitsFieldName2);
        happyFruits2.setFieldPosition(1);
        happyFruits2.setFieldType(FieldType.DECIMAL);
        happyFruits2.setTargetFieldName("transactionAmount");
        happyFruits.put(happyFruitsFieldName2, happyFruits2);

        MappingFieldMetadata happyFruits3 = new MappingFieldMetadata();
        String happyFruitsFieldName3 = "transDate";
        happyFruits3.setFieldName(happyFruitsFieldName3);
        happyFruits3.setFieldPosition(2);
        happyFruits3.setFieldType(FieldType.DATE);
        happyFruits3.setTargetFieldName("createdDate");
        happyFruits.put(happyFruitsFieldName3, happyFruits3);

        MappingFieldMetadata happyFruits4 = new MappingFieldMetadata();
        String happyFruitsFieldName4 = "adjustmentAmountCents";
        happyFruits4.setFieldName(happyFruitsFieldName4);
        happyFruits4.setFieldPosition(3);
        happyFruits4.setFieldType(FieldType.DECIMAL);
        happyFruits4.setTargetFieldName("adjustmentAmount");
        happyFruits.put(happyFruitsFieldName4, happyFruits4);

        MappingFieldMetadata happyFruits5 = new MappingFieldMetadata();
        String happyFruitsFieldName5 = "paymentTerm";
        happyFruits5.setFieldName(happyFruitsFieldName5);
        happyFruits5.setFieldPosition(4);
        happyFruits5.setFieldType(FieldType.INTEGER);
        happyFruits5.setTargetFieldName("paymentTerm");
        happyFruits.put(happyFruitsFieldName5, happyFruits5);

        MappingFieldMetadata happyFruits6 = new MappingFieldMetadata();
        String happyFruitsFieldName6 = "lines";
        happyFruits6.setFieldName(happyFruitsFieldName6);
        happyFruits6.setFieldPosition(5);
        happyFruits6.setFieldType(FieldType.JSON);
        happyFruits6.setTargetFieldName("invoiceItems");
        happyFruits.put(happyFruitsFieldName6, happyFruits6);

        MappingFieldMetadata happyFruits7 = new MappingFieldMetadata();
        String happyFruitsFieldName7 = "buyer";
        happyFruits7.setFieldName(happyFruitsFieldName7);
        happyFruits7.setFieldPosition(6);
        happyFruits7.setFieldType(FieldType.STRING);
        happyFruits7.setTargetFieldName("customerId");
        happyFruits.put(happyFruitsFieldName7, happyFruits7);

        MappingFieldMetadata happyFruits8 = new MappingFieldMetadata();
        String happyFruitsFieldName8 = "billingAddress";
        happyFruits8.setFieldName(happyFruitsFieldName8);
        happyFruits8.setFieldPosition(7);
        happyFruits8.setFieldType(FieldType.STRING);
        happyFruits8.setTargetFieldName("billingAddress");
        happyFruits.put(happyFruitsFieldName8, happyFruits8);

        MappingFieldMetadata happyFruits9 = new MappingFieldMetadata();
        String happyFruitsFieldName9 = "shippingAddress";
        happyFruits9.setFieldName(happyFruitsFieldName9);
        happyFruits9.setFieldPosition(8);
        happyFruits9.setFieldType(FieldType.STRING);
        happyFruits9.setTargetFieldName("shippingAddress");
        happyFruits.put(happyFruitsFieldName9, happyFruits9);

        MappingFieldMetadata happyFruits10 = new MappingFieldMetadata();
        String happyFruitsFieldName10 = "paidAmountCents";
        happyFruits10.setFieldName(happyFruitsFieldName10);
        happyFruits10.setFieldPosition(9);
        happyFruits10.setFieldType(FieldType.DECIMAL);
        happyFruits10.setTargetFieldName("paidAmount");
        happyFruits.put(happyFruitsFieldName10, happyFruits10);

        MappingFieldMetadata happyFruits11 = new MappingFieldMetadata();
        String happyFruitsFieldName11 = "paidAt";
        happyFruits11.setFieldName(happyFruitsFieldName11);
        happyFruits11.setFieldPosition(10);
        happyFruits11.setFieldType(FieldType.DATE);
        happyFruits11.setTargetFieldName("paidDate");
        happyFruits.put(happyFruitsFieldName11, happyFruits11);

        MappingFieldMetadata happyFruits12 = new MappingFieldMetadata();
        String happyFruitsFieldName12 = "memo";
        happyFruits12.setFieldName(happyFruitsFieldName12);
        happyFruits12.setFieldPosition(11);
        happyFruits12.setFieldType(FieldType.STRING);
        happyFruits12.setTargetFieldName("description");
        happyFruits.put(happyFruitsFieldName12, happyFruits12);

        companyMetaDataMap.put("customer-2",
                new CompanyDataMappingInfo("customer-2", "Happy Fruits", "yyyy-MM-dd",
                        AmountUnit.CENT, happyFruits));

    }

    public static CompanyDataMappingInfo getMetaDataMappingByCompanyId(String companyId) {
        return companyMetaDataMap.get(companyId);
    }
}
