package com.prototype.ot.microservices.projectservice.model.valueunitpair;

public abstract class ValueUnitPair {
    private String unit;
    private double value;

    public ValueUnitPair() {
        this.unit = "";
        this.value = 0.0;
    }

    public ValueUnitPair(String unit) {
        this.unit = unit;
        this.value = 0.0;
    }

    public ValueUnitPair(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
