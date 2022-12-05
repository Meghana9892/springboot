package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.model.Product;
import com.spring.service.Productservice;

@RestController
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private Productservice pservice;
	
	
	
	@PostMapping("/addproduct")
	public String addProductpage(@RequestBody Product product)
	{
		pservice.addProduct(product);
		
		return "Product Added successfully";
	}
	
	@PostMapping("/delete")
	public String deleteProductpage(@RequestBody Product product)
	{
		pservice.deleteProduct(product);
		
		return "Product Deleted successfully";
	}
	
	@GetMapping("/items")
	public List<Product> viewProductPage()
	{
		List<Product> products = pservice.allProducts();
		
		return products;
	}
	
	
	
	@PostMapping("/searchby")
	public List<Product> viewsearchPage(@RequestBody String userValue)
	{
		List<Product> products = pservice.getProductbyCategory(userValue 	);
		
		return products;
	}
}
