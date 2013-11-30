package org.rz.demo.store.web;

import org.apache.http.client.fluent.Request;
import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WebAppIT
{
	@Test
	public void helloWorld() throws Exception
	{
		String response = Request.Get("http://localhost:8090/store/HelloWorld").execute().returnContent().asString();
		Assertions.assertThat(response).as("response").isEqualTo("Hello World from MyService!");
	}
}
