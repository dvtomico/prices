package com.personal.prices.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

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
	void execute_OK() {
		String productId = "1";
		String brandId = "1";
		LocalDateTime applicationDateTime = LocalDateTime.now();
		Price price = Price.builder().brandId(brandId).productId(productId).
				priceList(1).startDate(LocalDateTime.now().minusDays(1)).
				endDate(LocalDateTime.now().plusDays(1)).priority(1).
				price(1.0).build();
		
		when(priceRepository.findByAndSort(brandId, productId, applicationDateTime, applicationDateTime))
			.thenReturn(price);
		
		Price response = priceGetFilteredUseCase.execute(applicationDateTime, productId, brandId);
		
		assertThat(response).isNotNull();
		assertThat(response).isEqualTo(price);
	}
	
	@Test
	void execute_KO_notFound() {
		String productId = "1";
		String brandId = "1";
		LocalDateTime applicationDateTime = LocalDateTime.now();

		when(priceRepository.findByAndSort(brandId, productId, applicationDateTime, applicationDateTime))
			.thenReturn(null);
		
		Exception exception = assertThrows(PriceNotFoundException.class, () -> {
			priceGetFilteredUseCase.execute(applicationDateTime, productId, brandId);
	    });
		
		assertThat(exception).isNotNull();
		assertThat(exception.getMessage()).isEqualTo("Price not found");
	}

}
