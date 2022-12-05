package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.Repository.ProductRepository;
import com.spring.model.Product;


@Service
public class Productservice {

	@Autowired
	private ProductRepository prepo;
	
	
	public void addProduct(Product p)
	{
		prepo.save(p);
	}
	public void deleteProduct(Product p)
	{
		prepo.delete(p);
	}
	
	public List<Product> allProducts()
	{
		return prepo.findAll();
		
	}
	
	public Product getProductbyId(int id)
	{
		Optional<Product> p = prepo.findById(id);
		Product product = p.get();
		return product;
		
	}
	
	public List<Product> getProductbyCategory(String userValue)
	{
		
		List<Product> productbycategory = prepo.findByCategory(userValue);
		if(productbycategory.size()==0)
		{
			productbycategory=prepo.findByProductname(userValue);
		}
		
		return productbycategory;
	}
}
