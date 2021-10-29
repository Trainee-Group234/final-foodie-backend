package com.yash.foodie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Counter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ids;
	private long id;
	private int qty;
	private double cost;
	private String title;
	@ManyToOne
	private Bill bill;
}
