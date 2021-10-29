package com.yash.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.foodie.domain.Bill;
import com.yash.foodie.serviceimpl.BillServieImpl;

@CrossOrigin
@RestController
@RequestMapping("api/foodie/bill")
public class BillController {

	@Autowired
	BillServieImpl billServieImpl;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBill(@RequestBody Bill bill){
		return new ResponseEntity<>(billServieImpl.saveBill(bill),HttpStatus.OK);
	}
	
	@GetMapping("/getbill/{username}")
	public ResponseEntity<?> getBillByName(@PathVariable("username") String username){
		return new ResponseEntity<>(billServieImpl.getBillByName(username),HttpStatus.OK);
	}
	
}
