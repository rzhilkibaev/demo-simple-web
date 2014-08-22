package org.simplemart.product;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.simplemart.product.resources.ProductResource;

public class ProductApp extends Application<ProductConfiguration> {

    public static void main(String[] args) throws Exception {
        new ProductApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
        // TODO Auto-generated method stub

    }

    @Override
    public void run(ProductConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new ProductResource());
    }

}
