package org.simplemart.product;

import io.dropwizard.Application;
import io.dropwizard.lifecycle.ServerLifecycleListener;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.simplemart.product.health.PingHealthCheck;
import org.simplemart.product.resources.ProductResource;

public class ProductApp extends Application<ProductConfiguration> implements ServerLifecycleListener {

    private volatile String host;
    private volatile int localAppPort;
    private volatile int localAdminPort;

    public static void main(String[] args) throws Exception {
        new ProductApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
    }

    @Override
    public void serverStarted(Server server) {
        host = ((ServerConnector) server.getConnectors()[0]).getHost();
        localAppPort = ((ServerConnector) server.getConnectors()[0]).getLocalPort();
        localAdminPort = ((ServerConnector) server.getConnectors()[1]).getLocalPort();
    }

    @Override
    public void run(ProductConfiguration configuration, Environment environment) throws Exception {
        environment.lifecycle().addServerLifecycleListener(this);
        environment.healthChecks().register("ping", new PingHealthCheck());
        environment.jersey().register(new ProductResource());
    }

    String getHost() {
        return host;
    }

    int getLocalAppPort() {
        return localAppPort;
    }

    int getLocalAdminPort() {
        return localAdminPort;
    }

}
