package com.personal.prices.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceJPARepository extends JpaRepository<PriceEntity, Long> {
	
	public List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String brandId, String productId, LocalDateTime applicationDateTime, LocalDateTime applicationDateTime2);


}
