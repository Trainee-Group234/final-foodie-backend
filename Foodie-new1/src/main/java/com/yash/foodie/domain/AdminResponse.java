package com.yash.foodie.domain;

import com.yash.foodie.payload.LoginRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {

	private LoginRequest login;
	private long totalDishes;
	private long totalCustomers;
	private long totalSales;
}
