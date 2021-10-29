package com.yash.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.foodie.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	Item findByItemName(String itemName);
	@Transactional
	@Modifying
	@Query("delete from Item i where i.itemName = :itemName")
	void removeByItemName(String itemName);
}
