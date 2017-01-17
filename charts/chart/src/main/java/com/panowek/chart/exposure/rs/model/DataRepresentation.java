package com.panowek.chart.exposure.rs.model;

import com.panowek.chart.exposure.rs.model.data.ChartDataRepresentation;
import com.panowek.chart.exposure.rs.model.data.ChartInfoRepresentation;

import java.util.Map;
import java.util.Set;

/**
 * @author radzik
 */
public class DataRepresentation {

    private Set<ChartDataRepresentation> data;
    private ChartInfoRepresentation chart;

    public DataRepresentation() {
        //for sake of Jackson
    }

    public DataRepresentation(Set<ChartDataRepresentation> data, ChartInfoRepresentation chart) {
        this.data = data;
        this.chart = chart;
    }

    public Set<ChartDataRepresentation> getData() {
        return data;
    }

    public ChartInfoRepresentation getChart() {
        return chart;
    }
}
