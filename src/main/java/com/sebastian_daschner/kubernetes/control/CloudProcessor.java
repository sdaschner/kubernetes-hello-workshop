package com.sebastian_daschner.kubernetes.control;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CloudProcessor {

    private Client client;
    private WebTarget target;

    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newClient();
        target = client.target("https://cloud-processor/cloud-processor/resources/forecast/simple");
    }

    public String getForecast() {
        try {
            return target
                    .request(MediaType.TEXT_PLAIN)
                    .get(String.class);
        } catch (Exception e) {
            System.err.println("Could not get forecast, reason: " + e.getMessage());
            return null;
        }
    }

    @PreDestroy
    public void closeClient() {
        client.close();
    }

}
