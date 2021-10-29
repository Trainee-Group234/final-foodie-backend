package com.yash.foodie.service;

import java.util.List;

import com.yash.foodie.domain.Category;
import com.yash.foodie.domain.Item;


public interface CategoryService {
	
	List<Item> getCategoryItemList(String categoryName);
	List<Category> getAllCategory();
	Category addCategory(Category category);
	void removeCategorybyName(String categoryName);
}
