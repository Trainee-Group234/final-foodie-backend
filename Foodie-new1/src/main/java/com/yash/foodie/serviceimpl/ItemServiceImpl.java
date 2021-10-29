package com.yash.foodie.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.foodie.domain.Item;
import com.yash.foodie.repository.ItemRepository;
import com.yash.foodie.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public void removeItem(Item item) {
		// TODO Auto-generated method stub
		itemRepository.delete(item);
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public Item viewItemById(long id) {
		// TODO Auto-generated method stub
		return itemRepository.getById(id);
	}

	@Override
	public List<Item> viewAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		return itemRepository.findByItemName(name);
	}

}
