package com.personal.prices.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.personal.prices.exception.PriceNotFoundException;
import com.personal.prices.repository.PriceRepository;

@ExtendWith(SpringExtension.class)
public class PriceGetFilteredUseCaseTest {
	
	@Mock
	private PriceRepository priceRepository;
	
	@InjectMocks
	private PriceGetFilteredUseCase priceGetFilteredUseCase;
	
	@Test
	void execute_OK_uniqueResult() {
		String productId = "1";
		String brandId = "1";
		LocalDateTime applicationDateTime = LocalDateTime.now();
		List<Price> priceList = List.of(Price.builder().brandId(brandId).productId(productId).
				priceList(1).startDate(LocalDateTime.now().minusDays(1)).
				endDate(LocalDateTime.now().plusDays(1)).priority(1).
				price(1.0).build());
		
		when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime))
			.thenReturn(priceList);
		
		Price response = priceGetFilteredUseCase.execute(applicationDateTime, productId, brandId);
		
		assertThat(response).isNotNull();
		assertThat(response).isEqualTo(priceList.get(0));
	}
	
	@Test
	void execute_OK_multipleResults() {
		String productId = "1";
		String brandId = "1";
		LocalDateTime applicationDateTime = LocalDateTime.now();
		List<Price> priceList = List.of(Price.builder().brandId(brandId).productId(productId).
				priceList(1).startDate(LocalDateTime.now().minusDays(1)).
				endDate(LocalDateTime.now().plusDays(1)).priority(1).
				price(1.0).build(),
				Price.builder().brandId(brandId).productId(productId).
				priceList(1).startDate(LocalDateTime.now().minusDays(1)).
				endDate(LocalDateTime.now().plusDays(1)).priority(2).
				price(1.0).build());
		
		when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime))
			.thenReturn(priceList);
		
		Price response = priceGetFilteredUseCase.execute(applicationDateTime, productId, brandId);
		
		assertThat(response).isNotNull();
		assertThat(response).isEqualTo(priceList.get(1));
	}
	
	@Test
	void execute_KO_notFound() {
		String productId = "1";
		String brandId = "1";
		LocalDateTime applicationDateTime = LocalDateTime.now();

		when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime))
			.thenReturn(Collections.emptyList());
		
		Exception exception = assertThrows(PriceNotFoundException.class, () -> {
			priceGetFilteredUseCase.execute(applicationDateTime, productId, brandId);
	    });
		
		assertThat(exception).isNotNull();
		assertThat(exception.getMessage()).isEqualTo("Price not found");
	}

}
