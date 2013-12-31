package org.rz.demo.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/HelloWorld")
@Controller
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String sayHelloWorld() {
		return "Hello World!";
	}
}
