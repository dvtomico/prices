package com.personal.prices.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.personal.prices.usecase.Price;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {
	
	private final PriceJPARepository priceRepository;
	
	private final PriceRepositoryMapper priceRepositoryMapper;

	@Override
	public List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
			String brandId, String productId, LocalDateTime applicationDateTime, LocalDateTime applicationDateTime2) {
		// TODO Auto-generated method stub
		return priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime2)
				.stream().map(priceRepositoryMapper::map).collect(Collectors.toList());
	}
	
	

}
