package com.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.model.Purchase;
import com.spring.model.User;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	 List<Purchase> findByUser(User user);
}
