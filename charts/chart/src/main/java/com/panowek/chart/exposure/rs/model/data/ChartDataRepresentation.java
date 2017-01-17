package com.panowek.chart.exposure.rs.model.data;

/**
 * Created by q1rp on 16-01-2017.
 */
public class ChartDataRepresentation {

    private String label;
    private String value;

    public ChartDataRepresentation() {
        //for sake of Jackson
    }

    public ChartDataRepresentation(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}
