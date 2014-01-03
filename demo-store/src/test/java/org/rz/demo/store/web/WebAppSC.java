package org.rz.demo.store.web;

import org.apache.http.client.fluent.Request;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

/**
 * Suite Class.
 * 
 * @author rz
 * 
 */
public class WebAppSC {

	@Test
	public void helloWorld() throws Exception {
		String response = Request.Get("http://localhost:" + SuiteIT.getLocalPort() + "/HelloWorld").execute().returnContent().asString();
		Assertions.assertThat(response).as("response").isEqualTo("Hello World!");
	}
}
