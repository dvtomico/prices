package com.personal.prices.usecase;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

	private String brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priceList;
	private String productId;
	private Integer priority;
	private Double price;
	private String currency;
	private LocalDateTime lastUpdate;
	private String lastUpdateBy;
	
}
