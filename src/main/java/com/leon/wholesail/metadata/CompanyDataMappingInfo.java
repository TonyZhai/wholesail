package com.leon.wholesail.metadata;

import com.leon.wholesail.enums.AmountUnit;

import java.util.Map;

public class CompanyDataMappingInfo {

    private String id;
    private String companyName;
    private String dateFormat;
    private AmountUnit amountUnit;
    private Map<String, MappingFieldMetadata> mappingFields;

    public CompanyDataMappingInfo(String id, String companyName, String dateFormat, AmountUnit amountUnit, Map<String, MappingFieldMetadata> mappingFields) {
        this.id = id;
        this.companyName = companyName;
        this.dateFormat = dateFormat;
        this.amountUnit = amountUnit;
        this.mappingFields = mappingFields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Map<String, MappingFieldMetadata> getMappingFields() {
        return mappingFields;
    }

    public void setMappingFields(Map<String, MappingFieldMetadata> mappingFields) {
        this.mappingFields = mappingFields;
    }

    public AmountUnit getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(AmountUnit amountUnit) {
        this.amountUnit = amountUnit;
    }
}

