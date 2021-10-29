package com.yash.foodie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Entity
@XmlRootElement
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cuisines;
	private double rating;
	private int reviews;
	private String thumbnailimage;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
//	@Singular
	private List<Item> menu = new ArrayList<Item>();
	public Category() {
		super();
	}
	public Category(long id, String name, String cuisines, double rating, int reviews, String thumbnailimage,
			List<Item> menu) {
		super();
		this.id = id;
		this.name = name;
		this.cuisines = cuisines;
		this.rating = rating;
		this.reviews = reviews;
		this.thumbnailimage = thumbnailimage;
		this.menu = menu;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisines() {
		return cuisines;
	}
	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public String getThumbnailimage() {
		return thumbnailimage;
	}
	public void setThumbnailimage(String thumbnailimage) {
		this.thumbnailimage = thumbnailimage;
	}
	public List<Item> getMenu() {
		return menu;
	}
	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", cuisines=" + cuisines + ", rating=" + rating + ", reviews="
				+ reviews + ", thumbnailimage=" + thumbnailimage + ", menu=" + menu + "]";
	}
	
	
	
}
