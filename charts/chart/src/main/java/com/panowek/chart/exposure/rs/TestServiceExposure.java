package com.panowek.chart.exposure.rs;

/**
 * Created by q1rp on 16-01-2017.
 */

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.Instant;

/**
 * @author Radoslaw Panowek
 */
@Stateless
@Path("/")
public class TestServiceExposure {

    @GET
    public String getTest() {
       return "Hello " + Instant.now();
    }

}
