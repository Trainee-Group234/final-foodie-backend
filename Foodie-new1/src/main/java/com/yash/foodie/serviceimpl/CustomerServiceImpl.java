package com.yash.foodie.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.foodie.domain.Customer;
import com.yash.foodie.repository.CustomerRepository;
import com.yash.foodie.service.CustomerService;
import com.yash.foodie.utils.PasswordEncryption;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	String asd = "asd";
	
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
//		String pwd= customer.getPassword();
//		 String encrptedPwd = passwordEncoder.encode(pwd);
//		 customer.setPassword(encrptedPwd);
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
	}

	@Override
	public Customer viewCustomerById(long id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).get();
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer viewCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

}
