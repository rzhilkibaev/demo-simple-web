package org.rz.demo.store.web;

import org.rz.demo.store.dao.ProductDao;
import org.rz.demo.store.rest.resource.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/products")
@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public Product get(@PathVariable String productId) {
		return productDao.getById(Long.valueOf(productId));
	}

}
