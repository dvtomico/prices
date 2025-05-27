package com.personal.prices.usecase;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.personal.prices.exception.PriceNotFoundException;
import com.personal.prices.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceGetFilteredUseCase {
	
	private final PriceRepository priceRepository;
	
	public Price execute(LocalDateTime applicationDateTime, String productId, 
			String brandId) {
		Price price = priceRepository.findByAndSort(brandId, productId, applicationDateTime, applicationDateTime);
		if(Objects.isNull(price)) {
			throw new PriceNotFoundException("Price not found");
		}
		return price;
	}

}
