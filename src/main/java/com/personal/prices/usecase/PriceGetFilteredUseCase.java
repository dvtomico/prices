package com.personal.prices.usecase;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.prices.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceGetFilteredUseCase {
	
	private final PriceRepository priceRepository;
	
	public List<Price> execute(LocalDateTime applicationDateTime, String productId, 
			String brandId) {
		return priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime);
	}

}
