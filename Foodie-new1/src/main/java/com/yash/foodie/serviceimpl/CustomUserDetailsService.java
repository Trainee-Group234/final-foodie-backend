package com.yash.foodie.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.foodie.domain.Customer;
import com.yash.foodie.exception.AccountNotActivatedExcetion;
import com.yash.foodie.repository.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,AccountNotActivatedExcetion {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByEmail(username);
		if(customer==null) {
			throw new UsernameNotFoundException("No user Found");
			
		}
		
		if( customer.getStatus()==0) {
			throw new AccountNotActivatedExcetion("Acccount Not Activated!");
		}
		
		return customer;
	}
	
	@Transactional
	public Customer loadByUserId(Long id) {
		return customerRepository.findById(id).get();
		
	}

}
