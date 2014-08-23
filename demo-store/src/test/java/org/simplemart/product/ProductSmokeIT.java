package org.simplemart.product;

import java.nio.charset.Charset;

import org.fest.assertions.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.simplemart.product.resources.Product;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class ProductSmokeIT {

    private static volatile String host = "localhost";
    private static volatile int appPort;
    private static volatile int adminPort;

    @BeforeClass
    public static void before() throws Exception {
        ProductApp app = new ProductApp();
        app.run(new String[] { "server", "target/test-classes/product-IT.yml" });
        host = nvl(app.getHost(), host);
        appPort = app.getLocalAppPort();
        adminPort = app.getLocalAdminPort();
    }

    @Test
    public void product_is_returned_when_request_is_made() {
        Product p = new Client().resource("http://" + host + ":" + appPort + "/product/abc").get(Product.class);
        Assertions.assertThat(p.getCaption()).as("product caption").isEqualTo("abc");
    }

    @Test
    public void app_is_alive() {
        ClientResponse pingRs = new Client().resource("http://" + host + ":" + adminPort + "/ping").get(ClientResponse.class);
        Assertions.assertThat(pingRs.getStatus()).as("ping response HTTP status").isEqualTo(ClientResponse.Status.OK.getStatusCode());
        Assertions.assertThat(streamToString(pingRs.getEntityInputStream()).trim()).as("ping response content").isEqualTo("pong");
    }

    private static String streamToString(java.io.InputStream is) {
        @SuppressWarnings("resource")
        java.util.Scanner s = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private static <T> T nvl(T test, T def) {
        return test == null ? def : test;
    }

}
