package ru.group.jug;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.ignite.client.IgniteClient;

@Path("/hello")
public class GreetingResource {

    @Inject
    SimpleService simpleService;
    @Inject
    IgniteClient igniteClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return simpleService.simpleMethod();
    }


}
