package com.leon.wholesail.utils;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.leon.wholesail.enums.AmountUnit;
import com.leon.wholesail.enums.FieldType;
import com.leon.wholesail.metadata.CompanyDataMappingInfo;
import com.leon.wholesail.metadata.MappingFieldMetadata;
import com.leon.wholesail.model.Invoice;
import com.leon.wholesail.repository.CompanyMetaDataMappingDataStore;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataParser {

    public static List<Invoice> parseData(String companyId, InputStream inputStream) throws NoSuchFieldException, IllegalAccessException, ParseException {
        CompanyDataMappingInfo companyDataMappingInfo = CompanyMetaDataMappingDataStore.getMetaDataMappingByCompanyId(companyId);
        Map<String, MappingFieldMetadata> mappings = companyDataMappingInfo.getMappingFields();
        List<Invoice> list = new ArrayList<>();
        try (Reader in = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8))) {
            // The first line is the header line, skip it
            List<CSVRecord> records = CSVUtil.getCsvRecords(in);
            for (int i = 1; i < records.size(); i++) {
                Iterator<String> it = mappings.keySet().iterator();
                Invoice invoice = new Invoice();
                while (it.hasNext()) {
                    String fieldName = it.next();
                    MappingFieldMetadata mapping = mappings.get(fieldName);
                    Field targetField = ReflectionUtils.findField(invoice.getClass(), mapping.getTargetFieldName());
                    ReflectionUtils.makeAccessible(targetField);
                    if (mapping.getFieldType() == FieldType.STRING) {
                        setField(invoice, targetField, getStringValue(records.get(i), mapping));
                    } else if (mapping.getFieldType() == FieldType.DATE) {
                        setField(invoice, targetField, getDateValue(records.get(i), mapping, companyDataMappingInfo.getDateFormat()));
                    } else if (mapping.getFieldType() == FieldType.INTEGER) {
                        setField(invoice, targetField, getIntegerValue(records.get(i), mapping));
                    } else if (mapping.getFieldType() == FieldType.JSON) {
                        setField(invoice, targetField, getStringValue(records.get(i), mapping));
                    } else if (mapping.getFieldType() == FieldType.DECIMAL) {
                        setField(invoice, targetField, getDecimalValue(records.get(i), mapping, companyDataMappingInfo.getAmountUnit()));
                    }
                }
                list.add(invoice);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static String getStringValue(CSVRecord csvRecord, MappingFieldMetadata fieldMetadata) {
        return csvRecord.get(fieldMetadata.getFieldPosition());
    }

    private static Integer getIntegerValue(CSVRecord csvRecord, MappingFieldMetadata fieldMetadata) {
        String value = csvRecord.get(fieldMetadata.getFieldPosition());
        if (StringUtils.isBlank(value)) {
            return Integer.valueOf(0);
        }
        return Integer.parseInt(value);
    }

    private static Date getDateValue(CSVRecord csvRecord, MappingFieldMetadata fieldMetadata, String dateFormat) throws ParseException {
        String value = csvRecord.get(fieldMetadata.getFieldPosition());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return new SimpleDateFormat(dateFormat).parse(value);
    }

    private static BigDecimal getDecimalValue(CSVRecord csvRecord, MappingFieldMetadata fieldMetadata, AmountUnit amountUnit) {
        String value = csvRecord.get(fieldMetadata.getFieldPosition());
        if (StringUtils.isBlank(value)) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimalValue = new BigDecimal(value);
        return amountUnit == AmountUnit.CENT ? bigDecimalValue.divide(BigDecimal.valueOf(100)) : bigDecimalValue;
    }

    private static <T> T getJsonValue(CSVRecord csvRecord, MappingFieldMetadata fieldMetadata, Class<T> clazz) {
        return new Gson().fromJson(csvRecord.get(fieldMetadata.getFieldPosition()), clazz);
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException, NoSuchFieldException, IllegalAccessException {
        DataParser.parseData("customer-1", new FileInputStream("data-golden-gate-produce-10.csv"));
    }

    private static void setField(Object obj, Field field, Object value) throws IllegalAccessException {
        if (value != null) {
            field.set(obj, value);
        }
    }
}
