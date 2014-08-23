package org.simplemart.product;

import io.dropwizard.Application;
import io.dropwizard.lifecycle.ServerLifecycleListener;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.simplemart.product.resources.ProductResource;

public class ProductApp extends Application<ProductConfiguration> implements ServerLifecycleListener {

    private volatile String host;
    private volatile int localPort;

    public static void main(String[] args) throws Exception {
        new ProductApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
        // TODO Auto-generated method stub
    }

    @Override
    public void serverStarted(Server server) {
        host = ((ServerConnector) server.getConnectors()[0]).getHost();
        localPort = ((ServerConnector) server.getConnectors()[0]).getLocalPort();
    }

    @Override
    public void run(ProductConfiguration configuration, Environment environment) throws Exception {
        environment.lifecycle().addServerLifecycleListener(this);
        environment.jersey().register(new ProductResource());
    }

    String getHost() {
        return host;
    }

    int getLocalPort() {
        return localPort;
    }

}
