package ru.group.jug;

import jakarta.inject.Singleton;
import jakarta.ws.rs.Produces;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.client.SslMode;
import org.apache.ignite.configuration.ClientConfiguration;

import static org.apache.ignite.ssl.SslContextFactory.DFLT_KEY_ALGORITHM;
import static org.apache.ignite.ssl.SslContextFactory.DFLT_STORE_TYPE;

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
        ClientConfiguration cfg = new ClientConfiguration()
                .setAddresses("127.0.0.1:10800")
                .setTimeout(123)
                .setSslMode(SslMode.REQUIRED)
                .setSslClientCertificateKeyStorePath("client.jks")
                .setSslClientCertificateKeyStoreType(DFLT_STORE_TYPE)
                .setSslClientCertificateKeyStorePassword("123456")
                .setSslTrustCertificateKeyStorePath("trust.jks")
                .setSslTrustCertificateKeyStoreType(DFLT_STORE_TYPE)
                .setSslTrustCertificateKeyStorePassword("123456")
                .setSslKeyAlgorithm(DFLT_KEY_ALGORITHM)
                .setHeartbeatInterval(3000)
                .setAutoBinaryConfigurationEnabled(false)
                .setHeartbeatEnabled(true);
        IgniteClient client = Ignition.startClient(cfg);
        ClientCache<String, String> clientCache = client.getOrCreateCache("JOKER_CACHE");
        clientCache.put("KEY", "Hello from Quarkus REST");
        return client;
    }
}
