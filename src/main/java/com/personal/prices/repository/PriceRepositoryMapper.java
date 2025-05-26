package com.personal.prices.repository;

import org.mapstruct.Mapper;

import com.personal.prices.usecase.Price;

@Mapper(componentModel = "spring")
public interface PriceRepositoryMapper {
	
	Price map(PriceEntity price);
	
}
