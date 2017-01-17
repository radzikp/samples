package com.panowek.chart.exposure.rs;

/**
 * Radosalw Panowek
 */

import com.panowek.chart.exposure.rs.model.DataFormat;
import com.panowek.chart.exposure.rs.model.DataRepresentation;
import com.panowek.chart.exposure.rs.model.OptionsRepresentations;
import com.panowek.chart.exposure.rs.model.data.ChartDataRepresentation;
import com.panowek.chart.exposure.rs.model.data.ChartInfoRepresentation;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author radzik
 */
@Stateless
@Path("/")
public class TestServiceExposure {

    @GET
    public String getTest() {
       return "Hello " + Instant.now();
    }

    @GET
    @Path("/options")
    @Produces(MediaType.APPLICATION_JSON)
    public OptionsRepresentations getOptions() {
        return mocked();

    }

    private OptionsRepresentations mocked() {
        ChartInfoRepresentation chart = new ChartInfoRepresentation(
                "Harry's SuperMart", "Top 5 stores in last month by revenue");
        DataRepresentation data = new DataRepresentation(data(), chart);
        OptionsRepresentations options = new OptionsRepresentations.Builder()
                .setDataFormat(DataFormat.JSON.getname())
                .setDataSource(data)
                .setId(UUID.randomUUID().toString())
                .setType("column2d")
                .setRenderAt("chart-container")
                .build();
        return options;
    }

    private Set<ChartDataRepresentation> data() {
        Set<ChartDataRepresentation> data = new HashSet<>();
        data.add(new ChartDataRepresentation("Bakersfield Central", "880000"));
        data.add(new ChartDataRepresentation("Garden Groove harbour", "730000"));
        data.add(new ChartDataRepresentation("Los Angeles Topanga", "590000"));
        data.add(new ChartDataRepresentation("Compton-Rancho Dom", "520000"));
        data.add(new ChartDataRepresentation("Daly City Serramont", "330000"));

//        Map<String, String> data = new HashMap<>();
//        data.put("Bakersfield Central", "880000");
//        data.put("Garden Groove harbour", "730000");
//        data.put("Los Angeles Topanga", "590000");
//        data.put("Compton-Rancho Dom", "520000");
//        data.put("Daly City Serramont", "330000");

        return data;
    }

}
