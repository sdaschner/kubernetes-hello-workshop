package com.sebastian_daschner.kubernetes.boundary;

import com.sebastian_daschner.kubernetes.control.Config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("config")
public class ConfigResource {

    @Inject
    Config config;

    @GET
    @Path("{key}")
    public String config(@PathParam("key") String key) {
        String value = config.get(key);

        if (value == null)
            throw new NotFoundException();

        return value;
    }

    @GET
    @Path("secret")
    public String secret() {
        String secret = config.getSecret();

        if (secret == null)
            throw new NotFoundException();

        return secret;
    }

}
