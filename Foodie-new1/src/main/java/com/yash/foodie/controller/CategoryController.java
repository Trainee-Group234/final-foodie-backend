package com.yash.foodie.controller;

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
import com.yash.foodie.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api/foodie/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/{category}")
	public ResponseEntity<?>  getByCategory(@PathVariable("category") String category){
		categoryService.getCategoryItemList(category);
		return new ResponseEntity<>(categoryService.getCategoryItemList(category),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>  getCategory(){
		return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@Valid @RequestBody Category category){
		return new ResponseEntity<>(categoryService.addCategory(category),HttpStatus.OK);
	}
}
