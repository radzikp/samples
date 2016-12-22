package com.panowek;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * @author Radoslaw Panowek
 */
@Stateless
@Path("/hello")
public class HelloResource {

    @Resource
    private ManagedExecutorService pool;

    @GET
    @Asynchronous
    public void asyncGet(@Suspended final AsyncResponse response) {
        supplyAsync(this::doSomeWork, this.pool).thenAccept(response::resume);
    }

    private String doSomeWork() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HelloResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        String msg = "+" + System.currentTimeMillis();

        Logger.getLogger(HelloResource.class.getName()).log(Level.INFO, msg);

        return msg;
    }


}
