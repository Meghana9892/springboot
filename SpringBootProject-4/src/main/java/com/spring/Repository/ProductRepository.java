package com.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Product;
import com.spring.model.Purchase;
import com.spring.model.User;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	 List<Product> findByCategory(String category);
	 List<Product> findByProductname(String productname);
}
