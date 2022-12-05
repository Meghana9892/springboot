package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Cart;
import com.spring.model.Product;
import com.spring.service.Cartservice;

@RestController
@CrossOrigin(origins="*")
public class CartController {

	@Autowired
	private Cartservice cartservice;
	
	@PostMapping("/addcart")
	public String addCartpage(@RequestBody Product product)
	{
		String output = cartservice.addCart(product);
		
		return output;
	}
	
	@GetMapping("/cart")
	public List<Cart> viewCartPage()
	{
		List<Cart> cartitems = cartservice.viewCart();
		
		
		return cartitems;
		
	}
	
	@GetMapping("/carttotal")
	public int viewcarttotal()
	{
		int total = cartservice.cartTotal();
		
		
		return total;
		
	}
	
	
	
}
