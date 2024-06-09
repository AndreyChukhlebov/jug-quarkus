package ru.group.jug;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class IgniteTest {

    @Inject
    IgniteClient igniteClient;

    @Test
    void testHelloEndpoint() {
        ClientCache<String, String> clientCache = igniteClient.cache("JOKER_CACHE");
        clientCache.put("asdg", "sdvgseg");
        String s = clientCache.get("asdg");
        Assertions.assertEquals("sdvgseg", s);
    }

}
