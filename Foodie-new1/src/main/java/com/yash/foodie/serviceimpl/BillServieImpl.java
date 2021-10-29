package com.yash.foodie.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.foodie.domain.Bill;
import com.yash.foodie.repository.BillRepository;

@Service
public class BillServieImpl {

	@Autowired
	BillRepository billRepository;
	@Transactional
	public Bill saveBill(Bill bill) {
		return billRepository.save(bill);
	}
	
	public Bill getBillByName(String name) {
		return billRepository.findByUsername(name);
	}
}
