package com.panowek.chart.exposure.rs.model;

/**
 * @author radzik
 */
public enum DataFormat {

    JSON("json"), JSONURL("jsonurl"), CSV("csv"), XML("xml"), XMLURL("xmlurl");

    private String name;

    DataFormat(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

}
