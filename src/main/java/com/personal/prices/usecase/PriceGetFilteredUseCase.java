package com.personal.prices.usecase;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
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
		List<Price> priceList = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime);
		Price price = priceList.stream().max(Comparator.comparing(Price::getPriority)).orElse(null);
		if(Objects.isNull(price)) {
			throw new PriceNotFoundException("Price not found");
		}
		return price;
	}

}
