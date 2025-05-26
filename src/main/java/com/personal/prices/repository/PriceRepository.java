package com.personal.prices.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.personal.prices.usecase.Price;

public interface PriceRepository {
	
	public List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String brandId, String productId, LocalDateTime applicationDateTime, LocalDateTime applicationDateTime2);

}
