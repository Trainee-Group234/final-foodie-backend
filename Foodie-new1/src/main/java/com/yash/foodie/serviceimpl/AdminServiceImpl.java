package com.yash.foodie.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.foodie.domain.Customer;
import com.yash.foodie.repository.CustomerRepository;

@Service
public class AdminServiceImpl {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void blockCustomer(String email) {
		Customer c = customerRepository.findByEmail(email);
		c.setStatus(0);
		customerRepository.save(c);
	}
	
	public void unblockCustomer(String email) {
		Customer c = customerRepository.findByEmail(email);
		c.setStatus(1);
		customerRepository.save(c);
	}
}
