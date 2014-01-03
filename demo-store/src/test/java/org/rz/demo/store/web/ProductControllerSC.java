package org.rz.demo.store.web;

import org.apache.http.client.fluent.Request;
import org.codehaus.jackson.map.ObjectMapper;
import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.rz.demo.store.rest.resource.Product;

/**
 * Suite Class.
 * 
 * @author rz
 * 
 */
public class ProductControllerSC {

	@Test
	public void get() throws Exception {

		String response = Request.Get("http://localhost:" + SuiteIT.getLocalPort() + "/products/0").execute().returnContent().asString();

		ObjectMapper mapper = new ObjectMapper();
		Product product = mapper.readValue(response, Product.class);

		Product expectedProduct = new Product();
		expectedProduct.setCaption("product caption");

		Assertions.assertThat(product).as("product").isEqualTo(expectedProduct);
	}

}
