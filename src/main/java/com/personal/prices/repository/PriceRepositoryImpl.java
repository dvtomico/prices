package com.personal.prices.repository;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.personal.prices.usecase.Price;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {
	
	private final PriceJPARepository priceRepository;
	
	private final PriceRepositoryMapper priceRepositoryMapper;

	@Override
	public Price findByAndSort(
			String brandId, String productId, LocalDateTime applicationDateTime, LocalDateTime applicationDateTime2) {
		// TODO Auto-generated method stub
		return priceRepositoryMapper.map(priceRepository.findByAndSort(brandId, productId, applicationDateTime, applicationDateTime2));
	}
	
	

}
