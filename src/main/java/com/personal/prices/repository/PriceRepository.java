package com.personal.prices.repository;

import java.time.LocalDateTime;

import com.personal.prices.usecase.Price;

public interface PriceRepository {
	
	public Price findByAndSort(String brandId, String productId, LocalDateTime applicationDateTime, LocalDateTime applicationDateTime2);

}
