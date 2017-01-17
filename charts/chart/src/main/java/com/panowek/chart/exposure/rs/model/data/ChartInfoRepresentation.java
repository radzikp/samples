package com.panowek.chart.exposure.rs.model.data;

/**
 * @author radzik
 */
public class ChartInfoRepresentation {

    private String caption;
    private String subCaption;

    public ChartInfoRepresentation() {
        //for sake of Jackson
    }

    public ChartInfoRepresentation(String caption, String subCaption) {
        this.caption = caption;
        this.subCaption = subCaption;
    }

    public String getCaption() {
        return caption;
    }

    public String getSubCaption() {
        return subCaption;
    }

}
