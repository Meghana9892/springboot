package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Repository.CartRepository;
import com.spring.Repository.ProductRepository;
import com.spring.model.Cart;
import com.spring.model.Product;



@Service
public class Cartservice {
	
	@Autowired
	private CartRepository crepo;
	
	@Autowired
	private ProductRepository prepo;

	@Autowired
	private Productservice pservice;
	
	public String addCart(Product p)
	{	
		Cart cart = new Cart();
		Cart item=null;
		
		List<Cart> cartitems = viewCart();
		int price = p.getPrice();
		int qty=0;
		String output="error";
		
		if(cartitems.size()==0)
		{
			cart.setQty(1);
			cart.setTotalprice(price);
			cart.setProduct(p);
			crepo.save(cart);
			output = "Added to Cart";
		}
		else 
	{
			
			for(Cart c:cartitems)
			{
				if(c.getProduct().getProductid()==p.getProductid())
				{
					 item= c;
				}
				
			}
			if(item!=null)
			{
				qty = item.getQty()+1;
				price = item.getProduct().getPrice()*qty;
				item.setQty(qty);
				item.setTotalprice(price);
				crepo.save(item);
				output = "Added to Cart if";
			}
			else
			{
				cart.setQty(1);
				cart.setTotalprice(price);
				cart.setProduct(p);
				crepo.save(cart);
				output = "Added to Cart";
			}
			
		
			
		}
		
			return output;
			
	}
		
		
		
	

	
	public List<Cart> viewCart()
	{
		List<Cart> cartitems = crepo.findAll();
				return cartitems;
		
	}
	
	public Cart getCartById(int id)
	{
		Optional<Cart> c = crepo.findById(id);
		Cart cart = c.get();
		return cart;
		
	}
	
	public int cartTotal()
	{
		int total=0;
		
		List<Cart> cartitems = crepo.findAll();
		
		for(Cart c:cartitems)
		{
			total = total + c.getTotalprice();
		}
		
	return total;
		}
	
	public void deletecart()
	{
		 crepo.deleteAllInBatch();
	}
}


