package org.rz.demo.store.web;

import org.rz.demo.store.dao.ProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class StoreServletConfig {

	@Bean
	public ProductDao productDao() {
		return new ProductDao();
	}
}
