package ru.group.jug;

import jakarta.inject.Singleton;
import jakarta.ws.rs.Produces;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.jboss.resteasy.reactive.Cache;

@Singleton
public class IgniteConfig {

    @Singleton
    @Produces
    SimpleService simpleService(
            IgniteClient igniteClient
    ) {
        return new SimpleServiceImpl(igniteClient);
    }

    @Singleton
    @Produces
    IgniteClient igniteClient() {
        ClientConfiguration cfg = new ClientConfiguration().setAddresses("127.0.0.1:10800");
        IgniteClient client = Ignition.startClient(cfg);
        ClientCache<String, String> clientCache = client.getOrCreateCache("JOKER_CACHE");
        clientCache.put("KEY", "Hello from Quarkus REST");
        return client;
    }

}
