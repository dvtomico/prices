package com.personal.prices.repository;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prices")
public class PriceEntity {
	@Id
	private Long id;
	@Column(name="brand_id")
	private String brandId;
	@Column(name="start_date")
	private LocalDateTime startDate;
	@Column(name="end_date")
	private LocalDateTime endDate;
	@Column(name="price_list")
	private Integer priceList;
	@Column(name="product_id")
	private String productId;
	private Integer priority;
	private Double price;
	private String currency;
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	@Column(name="last_update_by")
	private String lastUpdateBy;

}
