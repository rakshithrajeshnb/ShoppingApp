package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products") //http://localhost:8081/products
public class ProductController {
	@Autowired
	ProductService service;
	
	//@RequestMapping(method=RequestMethod.POST,consumes="application.json",value="/save")
	@PostMapping("/save")  //http://localhost:8080/products/save
	public String saveProduct(@RequestBody Product product)
	{
		return service.addProduct(product);
	}
	
}
