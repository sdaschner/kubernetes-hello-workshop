package com.sebastian_daschner.kubernetes.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.Instant;

@Path("hello")
public class HelloResource {

    @GET
    public String hello() {
        return "Hello Kubernetes";
    }

}
