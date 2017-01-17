package com.panowek.chart.exposure.rs.model;

/**
 * @author radzik
 */
public class OptionsRepresentations {

    private String type;
    private String id;
    private String width;
    private String height;
    private String renderAt;
    private String dataFormat;
    private DataRepresentation dataSource;

    public OptionsRepresentations() {
        //for sake of Jackson
    }

    public OptionsRepresentations(OptionsRepresentations.Builder builder) {
        this.type = builder.type;
        this.id = builder.id;
        this.width = builder.width;
        this.height = builder.height;
        this.renderAt = builder.renderAt;
        this.dataFormat = builder.dataFormat;
        this.dataSource = builder.dataSource;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getRenderAt() {
        return renderAt;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public DataRepresentation getDataSource() {
        return dataSource;
    }

    /**
     * Builder for constructing Options Representations
     */
    public static class Builder {

        private String type;
        private String id;
        private String width;
        private String height;
        private String renderAt;
        private String dataFormat;
        private DataRepresentation dataSource;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setWidth(String width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(String height) {
            this.height = height;
            return this;
        }

        public Builder setRenderAt(String renderAt) {
            this.renderAt = renderAt;
            return this;
        }

        public Builder setDataFormat(String dataFormat) {
            this.dataFormat = dataFormat;
            return this;
        }

        public Builder setDataSource(DataRepresentation dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public OptionsRepresentations build() {
            return new OptionsRepresentations(this);
        }

    }



}
