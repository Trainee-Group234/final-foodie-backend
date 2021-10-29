package com.yash.foodie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yash.foodie.domain.AdminResponse;
import com.yash.foodie.domain.Category;
import com.yash.foodie.domain.Item;
import com.yash.foodie.exception.InvalidLoginResponse;
import com.yash.foodie.payload.LoginRequest;
import com.yash.foodie.repository.BillRepository;
import com.yash.foodie.repository.CategoryRepository;
import com.yash.foodie.repository.CustomerRepository;
import com.yash.foodie.repository.ItemRepository;
import com.yash.foodie.service.CategoryService;
import com.yash.foodie.service.ItemService;
import com.yash.foodie.serviceimpl.AdminServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class AdminController {
	
		@Autowired
		AdminServiceImpl adminServiceImpl;
		
		@Autowired
		CategoryService categoryService;
		
		@Autowired
		CategoryRepository categoryRepository;
		
		@Autowired
		ItemService itemService;
		
		@Autowired
		ItemRepository itemRepository;
		
		@Autowired
		BillRepository billRepository;
		
		@Autowired
		CustomerRepository customerRepository;
		
		//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@GetMapping("block/{email}")
		public ResponseEntity<?> blockCustomer(@PathVariable("email") String email){
			adminServiceImpl.blockCustomer(email);
			return new ResponseEntity<>("Account Blocked!",HttpStatus.OK);
		}
		
		//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@GetMapping("unblock/{email}")
		public ResponseEntity<?> unblockCustomer(@PathVariable("email") String email){
			adminServiceImpl.unblockCustomer(email);
			return new ResponseEntity<>("Account Un-Blocked!",HttpStatus.OK);
		}
		
		@PostMapping("admin/login")
		public ResponseEntity<?> verifyAdmin(@Valid @RequestBody LoginRequest login){
			if(login.getUsername().equals("admin@foodie.com") && login.getPassword().equals("admin")) {
				long totalDishes = itemRepository.count();
				long totalCustomers = customerRepository.count();
				long totalSale = billRepository.totalSales();
				AdminResponse ar = new AdminResponse(login, totalDishes, totalCustomers,totalSale);
				return new ResponseEntity<>(ar,HttpStatus.OK);
			}
			else {
				InvalidLoginResponse res = new InvalidLoginResponse();
				String jsonResponse = 	new Gson().toJson(res);
				return new ResponseEntity<>(jsonResponse,HttpStatus.UNAUTHORIZED);
			}
		}
		
		@GetMapping("items/all")
		public ResponseEntity<?> getItems(){
			return new ResponseEntity<>(itemService.viewAllItems(),HttpStatus.OK);
		}
		
		@GetMapping("category/all")
		public ResponseEntity<?>  getCategory(){
			return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
		}
		
		@DeleteMapping("delete/{name}")
		public ResponseEntity<?> removeCategory(@PathVariable("name") String name){
			categoryService.removeCategorybyName(name);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		@PostMapping("category/add")
		public ResponseEntity<?> addCategory( @Valid @RequestBody Category category){
			return new ResponseEntity<>(categoryService.addCategory(category),HttpStatus.OK);
		}
		
		@PostMapping("item/add")
		public ResponseEntity<?> addorUpdateItem(@Valid @RequestBody Item item){
			Category category = categoryRepository.findByName(item.getCategoryName()).get();
			item.setCategory(category);
			return new ResponseEntity<Item>((Item)itemService.addItem(item), HttpStatus.OK);
		}
		
		@DeleteMapping("item/delete/{name}")
		public ResponseEntity<?> removeByItemName(@PathVariable("name") String name){
			itemRepository.removeByItemName(name);
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
