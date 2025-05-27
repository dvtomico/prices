package com.personal.prices.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

public interface PriceJPARepository extends JpaRepository<PriceEntity, Long> {
	
	@NativeQuery("SELECT * FROM prices WHERE brand_id = :brandId AND product_id = :productId AND start_date <= :applicationDateTime AND end_date >= :applicationDateTime2 order by priority desc limit 1")
	public PriceEntity findByAndSort(String brandId, String productId, LocalDateTime applicationDateTime, LocalDateTime applicationDateTime2);

}
