package com.yash.foodie.service;

import java.util.List;
import java.util.Optional;

import com.yash.foodie.domain.Customer;

public interface CustomerService {
	 Customer addCustomer(Customer customer);
	 void deleteCustomer(Customer customer);
	 Customer viewCustomerById(long id);
	 List<Customer> viewAllCustomer();
	 Customer viewCustomerByEmail(String email);
}
