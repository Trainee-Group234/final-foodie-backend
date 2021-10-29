package com.yash.foodie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String building_name;
	private String street;
	private String city;
	private long pincode;
	@OneToOne(mappedBy = "address")
	private Customer customer;
	public Address() {
		super();
	}
	public Address(long id, String building_name, String street, String city, long pincode) {
		super();
		this.id = id;
		this.building_name = building_name;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getbuilding_name() {
		return building_name;
	}
	public void setbuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", building_name=" + building_name + ", street=" + street + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}

}
