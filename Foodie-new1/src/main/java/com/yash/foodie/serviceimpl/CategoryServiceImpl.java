package com.yash.foodie.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.foodie.domain.Category;
import com.yash.foodie.domain.Item;
import com.yash.foodie.repository.CategoryRepository;
import com.yash.foodie.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Item> getCategoryItemList(String categoryName) {
		// TODO Auto-generated method stub
		Category c = categoryRepository.findByName(categoryName).get();
		System.out.println(c.getMenu());
		return c.getMenu();
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Transactional
	@Override
	public void removeCategorybyName(String categoryName) {
		// TODO Auto-generated method stub
		categoryRepository.deleteByName(categoryName);
	}

}
