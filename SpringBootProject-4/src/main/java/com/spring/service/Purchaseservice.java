package com.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Repository.PurchaseRepository;
import com.spring.Repository.UserRepository;
import com.spring.model.Cart;
import com.spring.model.Purchase;
import com.spring.model.User;

@Service
public class Purchaseservice {

	@Autowired
	private PurchaseRepository prepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private Cartservice cartservice;
	
	public String buy(User user)
	{
		String output = null;
		List<Cart> cart = cartservice.viewCart();
		 Date date = new Date();
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	      String strdate = formatter.format(date);
		
		if(cart.size()==0)
		{
			output="False";
		}
		
		for(Cart c:cart)
		{	
			Purchase p = new Purchase();
			p.setProductname(c.getProduct().getProductname());
			p.setPurchasedate(strdate);
			p.setQuantity(c.getQty());
			p.setTotalprice(c.getTotalprice());
			p.setUser(user);
			prepo.save(p);
			output = "true";
		}
		return output;
	}
	
	public List<Purchase> purchasehistory(User user)
	{
		
		List<Purchase> purchases = prepo.findByUser(user);
		
		return purchases;
	}
	public List<Purchase> purchases()
	{
		
		List<Purchase> purchases = prepo.findAll();
		
		return purchases;
	}
}
