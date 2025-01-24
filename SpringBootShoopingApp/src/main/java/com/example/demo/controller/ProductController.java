package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products") //http://localhost:8080/products
@AllArgsConstructor
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	ProductService service;
	
	//@RequestMapping(method=RequestMethod.POST,consumes="application.json",value="/save")
	@PostMapping("/save")  //http://localhost:8080/products/save
	public String saveProduct(@RequestBody Product product)
	{
		logger.info("Received request to save product: {}", product);
	    String response = service.addProduct(product);
	    logger.info("Product saved successfully with response: {}", response);
		return service.addProduct(product);
	}
	
	@PutMapping("/update")  //http://localhost:8080/products/update
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")  //http://localhost:8080/products/delete/123
	public String deleteProduct(@PathVariable("id") int productId)
	{
		return service.deleteProduct(productId);
	}
	
	@GetMapping("/getById/{id}")  //http://localhost:8080/products/getById/123
	public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound
	{
		return service.getProductById(productId);
	}
	
	@GetMapping("/getByCategory/{category}")  //http://localhost:8080/products/getByCategory/electronics
	public List<Product> getProductsByCategory(@PathVariable("category") String productCategory) throws ProductNotFound
	{
	    return service.getProductByCategory(productCategory);
	}

	@GetMapping("/ ")  //http://localhost:8080/products/getAll
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("/getByCategoryAndPriceLessThan/{category}/{price}")  //http://localhost:8080/products/getByCategoryAndPriceLessThan/electronics/1000
	public List<Product> getByCategoryAndPriceLessThan(@PathVariable("category") String category, @PathVariable("price") int price) {
	    return service.getByProductCategoryAndProductPriceLessThan(category, price);
	}


	
}


