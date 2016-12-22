package com.panowek;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *@author Radoslaw Panowek
 */
@Stateless
@Path("hello")
public class HelloResource {

    private Client client;
    private WebTarget macroTarget;

    @PostConstruct
    public void init() {
        this.client = ClientBuilder.newClient();
        this.macroTarget = this.client.target("http://localhost:7001/macro1/hello");
    }

    @GET
    public String hello() {
        getRemoteMessage();
        return "OK";
    }

    Future<String> getRemoteMessage() {
        Logger.getLogger(HelloResource.class.getName()).log(Level.INFO, "Starting time consuming task...");
        return this.macroTarget.request().async().get(new InvocationCallback<String>() {
            @Override
            public void completed(String msg) {
                Logger.getLogger(HelloResource.class.getName()).log(Level.INFO, "Completed!");
                Logger.getLogger(HelloResource.class.getName()).log(Level.INFO, msg);
            }

            @Override
            public void failed(Throwable throwable) {
                Logger.getLogger(HelloResource.class.getName()).log(Level.SEVERE, throwable.getMessage());
            }
        });
    }

}
