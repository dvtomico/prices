package com.personal.prices.controller;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDto {
	
	private String productId;
	private String brandId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
	
}
