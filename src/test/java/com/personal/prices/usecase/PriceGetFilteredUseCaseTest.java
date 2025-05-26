package com.personal.prices.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
		List<Price> priceList = List.of(
				Price.builder().brandId(brandId).productId(productId).
				priceList(1).startDate(LocalDateTime.now().minusDays(1)).
				endDate(LocalDateTime.now().plusDays(1)).priority(1).
				price(1.0).build()
				);
		
		when(priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, applicationDateTime, applicationDateTime))
			.thenReturn(priceList);
		
		List<Price> response = priceGetFilteredUseCase.execute(applicationDateTime, productId, brandId);
		
		assertThat(response).isNotNull();
		assertThat(response).isNotEmpty();
		assertThat(response).hasSize(1);
		assertThat(response).containsAll(priceList);
	}

}
