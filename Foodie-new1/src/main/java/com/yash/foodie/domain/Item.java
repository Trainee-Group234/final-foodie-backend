package com.yash.foodie.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@XmlRootElement
@Table(name = "Items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "category")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	private String itemName;
	private String categoryName;
	private int quantity;
	private String description;
	private double cost;
	@ManyToOne//(fetch = FetchType.EAGER)
	private Category category;
	
//	public Item() {
//		super();
//	}
//	
//	public Item(long itemId, String itemName, String categoryName, int quantity, double cost, Category category) {
//		super();
//		this.itemId = itemId;
//		this.itemName = itemName;
//		this.categoryName = categoryName;
//		this.quantity = quantity;
//		this.cost = cost;
//		this.category = category;
//	}
//
//	public long getItemId() {
//		return itemId;
//	}
//	public void setItemId(long itemId) {
//		this.itemId = itemId;
//	}
//	public String getItemName() {
//		return itemName;
//	}
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
//	public Category getCategory() {
//		return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public double getCost() {
//		return cost;
//	}
//	public void setCost(double cost) {
//		this.cost = cost;
//	}
//	
//	
//	
//	public String getCategoryName() {
//		return categoryName;
//	}
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}
//
//	@Override
//	public String toString() {
//		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", categoryName=" + categoryName + ", quantity="
//				+ quantity + ", cost=" + cost + "]";
//	}
	

}
