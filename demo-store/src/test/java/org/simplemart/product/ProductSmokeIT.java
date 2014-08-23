package org.simplemart.product;

import org.fest.assertions.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.simplemart.product.resources.Product;

import com.sun.jersey.api.client.Client;

public class ProductSmokeIT {

    private static volatile String host = "localhost";
    private static volatile int port;

    @BeforeClass
    public static void before() throws Exception {
        ProductApp app = new ProductApp();
        app.run(new String[] {"server", "target/test-classes/product-IT.yml" });
        host = nvl(app.getHost(), host);
        port = app.getLocalPort();
    }

    @Test
    public void product_is_returned_when_request_is_made() {
        Product p = new Client().resource("http://" + host + ":" + port + "/product/abc").get(Product.class);
        Assertions.assertThat(p.getCaption()).as("product caption").isEqualTo("abc");
    }

    private static <T> T nvl(T test, T def) {
        return test == null ? def : test;
    }

}
