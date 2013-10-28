package org.rz.demo.store.web;

import org.rz.demo.store.abc.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/HelloWorld")
@Controller
public class HelloWorldController {

	@Autowired
	private MyService s;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String sayHelloWorld() {
		return s.getInfo();
	}
}
