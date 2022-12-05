package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Repository.ProductRepository;
import com.spring.Repository.PurchaseRepository;
import com.spring.model.Product;
import com.spring.model.Purchase;
import com.spring.model.User;
import com.spring.service.Cartservice;
import com.spring.service.Purchaseservice;
import com.spring.service.Userservice;

@RestController
@CrossOrigin(origins="*")
public class PurchaseController {

	@Autowired
	private Purchaseservice pservice;
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private Cartservice cartservice;;
	
	
	
	@PostMapping("/buy")
	public String purchasepage(@RequestBody String username)
	{
		User user = userservice.getUserbyname(username);
		String output =pservice.buy(user);
		
		cartservice.deletecart();
		
		return output;


	}
	
	@PostMapping("/purchases")
	public List<Purchase> purchasehistorypage(@RequestBody String username)
	{

		User user = userservice.getUserbyname(username);
			 
		
		List<Purchase> purchases = pservice.purchasehistory(user);
		
		
		return purchases;

	}
	
	@GetMapping("/purchasehistory")
	public List<Purchase> viewProductPage()
	{
		List<Purchase> purchases = pservice.purchases();
		
		return purchases;
	}
	
}
