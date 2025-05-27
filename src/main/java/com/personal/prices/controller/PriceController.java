package com.personal.prices.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.prices.usecase.Price;
import com.personal.prices.usecase.PriceGetFilteredUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/prices")
@RequiredArgsConstructor
public class PriceController {
	
	private final PriceGetFilteredUseCase priceGetFiltered;
	
	private final PriceRestMapper priceRestMapper;
	
	@GetMapping
	public ResponseEntity<PriceDto> getPricesFiltered(@RequestParam LocalDateTime applicationDateTime, @RequestParam String productId, 
			@RequestParam String brandId) {
		Price price = priceGetFiltered.execute(applicationDateTime, productId, brandId);
        PriceDto pricesDto = priceRestMapper.map(price);
        return new ResponseEntity<>(pricesDto, HttpStatus.OK);
    }
	

}
