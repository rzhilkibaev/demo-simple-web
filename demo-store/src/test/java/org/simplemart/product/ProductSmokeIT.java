package org.simplemart.product;

import org.fest.assertions.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.simplemart.product.resources.Product;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ProductSmokeIT {

    private final WebResource productResource = new Client().resource("http://localhost:8080/product/abc");

    @BeforeClass
    public static void before() throws Exception {
        new ProductApp().run(new String[] {"server", "target/classes/product.yml"});
    }

    @Test
    public void product_is_returned_when_request_is_made() {
        Product p = productResource.get(Product.class);
        Assertions.assertThat(p.getCaption()).as("product caption").isEqualTo("abc");
    }
}
