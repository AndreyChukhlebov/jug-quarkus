package ru.group.jug;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.ignite.client.IgniteClient;
import org.jboss.logging.Logger;


@Path("/hello")
public class GreetingResource {

    @Inject
    SimpleService simpleService;
    @Inject
    IgniteClient igniteClient;
    private static final Logger log = Logger.getLogger(GreetingResource.class);
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return simpleService.simpleMethod();
    }


}
