package com.yash.foodie.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.foodie.domain.Customer;
import com.yash.foodie.payload.JWTLoginSuccessResponse;
import com.yash.foodie.payload.LoginRequest;
import com.yash.foodie.repository.CustomerRepository;
import com.yash.foodie.security.JwtTokenProvider;
import com.yash.foodie.service.CustomerService;
import com.yash.foodie.service.EmailSenderService;
import com.yash.foodie.utils.SecurityConstants;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	EmailSenderService emailSenderService = new EmailSenderService() {
		
		@Override
		public void sendSimpleEmail(String toEmail, String body, String subject) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment)
				throws MessagingException {
			// TODO Auto-generated method stub
			
		}
	};
	
	@PostMapping
	public ResponseEntity<?> saveOrUpdateCustomer(@Valid @RequestBody Customer customer) {
		emailSenderService.sendSimpleEmail(customer.getEmail(), "Your Account has been Successfully Created!\n"
				+ "Click on the below link to Activate\n http://localhost:8081/api/customer/verify/"+customer.getEmail()+"", "Foodie.com");
		String pwd= customer.getPassword();
		 String encrptedPwd = passwordEncoder.encode(pwd);
		 customer.setPassword(encrptedPwd);
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@GetMapping("verify/{email}")
	public ResponseEntity<?> verifyMail(@PathVariable("email") String email){
		Customer c = customerRepository.findByEmail(email);
		if(c!=null) {
			c.setStatus(1);
			customerRepository.save(c);
			return new ResponseEntity<>("Your Account verified \n Login link:- http://localhost:3000/login",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Bad Request!", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer){
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") long id){
		return new ResponseEntity<Customer>(customerService.viewCustomerById(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomer(), HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getCustomerByEmail(@PathVariable("email") String email){
		return new ResponseEntity<Customer>(customerService.viewCustomerByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> jwtTokenProvider(@Valid @RequestBody LoginRequest loginRequest){ 
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = SecurityConstants.TOKEN_PREFIX + tokenProvider.generateToken(authentication);
		return new ResponseEntity<>(new JWTLoginSuccessResponse(true,jwt),HttpStatus.OK);
	}
}
