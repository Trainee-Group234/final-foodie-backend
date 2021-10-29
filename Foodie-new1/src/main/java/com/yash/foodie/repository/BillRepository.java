package com.yash.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.foodie.domain.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill findByUsername(String name);
	@Query("select sum(total) from Bill")
	long totalSales();
}
