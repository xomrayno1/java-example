package com.tampro.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@GetMapping
	public String getMessage() {
		String message = "Xin chào friends";
		log.info("get message successfully");
		return message;
	}
	

}
