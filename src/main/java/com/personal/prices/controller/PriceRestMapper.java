package com.personal.prices.controller;

import org.mapstruct.Mapper;

import com.personal.prices.usecase.Price;

@Mapper(componentModel = "spring")
public interface PriceRestMapper {
	
	PriceDto map(Price price);
	
}
