package com.yash.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import com.yash.foodie.domain.Category;
import com.yash.foodie.domain.Item;
import com.yash.foodie.repository.CategoryRepository;
import com.yash.foodie.service.ItemService;

@RestController
@RequestMapping("api/foodie/item")
@CrossOrigin
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping
	public ResponseEntity<?> addorUpdateItem(@Valid @RequestBody Item item){
		//List<Item> items= new ArrayList<>(); 
		Category category = categoryRepository.findByName(item.getCategoryName()).get();
//		category.setItemList(items);
//		categoryRepository.save(category);
		item.setCategory(category);
		return new ResponseEntity<Item>((Item)itemService.addItem(item), HttpStatus.OK);
	}
	
	@GetMapping("/{item}")
	public ResponseEntity<?> getItemByName(@PathVariable("item") String itemName){
		return new ResponseEntity<>(itemService.viewAllItemsByName(itemName),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getItems(){
		return new ResponseEntity<>(itemService.viewAllItems(),HttpStatus.OK);
	}
}
