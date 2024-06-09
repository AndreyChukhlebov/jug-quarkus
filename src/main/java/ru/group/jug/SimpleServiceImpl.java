package ru.group.jug;

import org.apache.ignite.client.IgniteClient;

public class SimpleServiceImpl implements SimpleService {

    private final IgniteClient igniteClient;

    public SimpleServiceImpl(
            IgniteClient igniteClient
    ) {
        this.igniteClient = igniteClient;
    }

    @Override
    public String simpleMethod() {
        return (String) igniteClient.cache("JOKER_CACHE").get("KEY");
    }
}
