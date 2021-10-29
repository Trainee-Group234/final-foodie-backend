package com.yash.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.foodie.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//	Customer findByCustomerId(String upperCase);
	Customer findByEmail(String email);
}