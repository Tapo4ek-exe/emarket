package ru.emarket.productapi.models;

public class SpecificationValue {
    private Long id;
    private Long specificationId;
    private int valueInt;
    private double valueDouble;
    private String valueString;

    public SpecificationValue(Long id, Long specificationId, int valueInt, double valueDouble, String valueString) {
        this.id = id;
        this.specificationId = specificationId;
        this.valueInt = valueInt;
        this.valueDouble = valueDouble;
        this.valueString = valueString;
    }

    public SpecificationValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public double getValueDouble() {
        return valueDouble;
    }

    public void setValueDouble(double valueDouble) {
        this.valueDouble = valueDouble;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }
}
