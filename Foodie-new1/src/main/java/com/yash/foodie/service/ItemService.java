package com.yash.foodie.service;

import java.util.List;

import com.yash.foodie.domain.Item;

public interface ItemService {
	
	Item addItem(Item item);
	void removeItem(Item item);
	Item updateItem(Item item);
	Item viewItemById(long id);
	List<Item> viewAllItems();
	Item viewAllItemsByName(String name);
}
