package org.rz.demo.store.dao;

import org.rz.demo.store.rest.resource.Product;

public class ProductDao {

	public Product getById(long id) {
		Product p = new Product();
		p.setCaption("product caption");
		return p;
	}
}
