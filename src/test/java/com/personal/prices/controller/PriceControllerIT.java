package com.personal.prices.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.personal.prices.PricesApplication;

@SpringBootTest(classes = {PricesApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String productId = "35455";
	private String brandId = "1";
	private final static String URL_BASE = "/api/v1/prices?";
	
	@Test
	void getPricesFiltered1() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<List<PriceDto>> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            new ParameterizedTypeReference<List<PriceDto>>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isNotEmpty();
		assertThat(response.getBody().size()).isEqualTo(1);
		assertThat(response.getBody().get(0).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(0).getPriceList()).isEqualTo(1);
		assertThat(response.getBody().get(0).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().get(0).getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().get(0).getPrice()).isEqualTo(35.50);
	}
	
	@Test
	void getPricesFiltered2() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 14, 16, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<List<PriceDto>> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            new ParameterizedTypeReference<List<PriceDto>>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isNotEmpty();
		assertThat(response.getBody().size()).isEqualTo(2);
		assertThat(response.getBody().get(0).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(0).getPriceList()).isEqualTo(1);
		assertThat(response.getBody().get(0).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().get(0).getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().get(0).getPrice()).isEqualTo(35.50);
		assertThat(response.getBody().get(1).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(1).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(1).getPriceList()).isEqualTo(2);
		assertThat(response.getBody().get(1).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 15, 00, 00));
		assertThat(response.getBody().get(1).getEndDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 18, 30, 00));
		assertThat(response.getBody().get(1).getPrice()).isEqualTo(25.45);
	}
	
	@Test
	void getPricesFiltered3() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 14, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<List<PriceDto>> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            new ParameterizedTypeReference<List<PriceDto>>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isNotEmpty();
		assertThat(response.getBody().size()).isEqualTo(1);
		assertThat(response.getBody().get(0).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(0).getPriceList()).isEqualTo(1);
		assertThat(response.getBody().get(0).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().get(0).getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().get(0).getPrice()).isEqualTo(35.50);
	}
	
	@Test
	void getPricesFiltered4() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<List<PriceDto>> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            new ParameterizedTypeReference<List<PriceDto>>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isNotEmpty();
		assertThat(response.getBody().size()).isEqualTo(2);
		assertThat(response.getBody().get(0).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(0).getPriceList()).isEqualTo(1);
		assertThat(response.getBody().get(0).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().get(0).getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().get(0).getPrice()).isEqualTo(35.50);
		assertThat(response.getBody().get(1).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(1).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(1).getPriceList()).isEqualTo(3);
		assertThat(response.getBody().get(1).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 15, 00, 00, 00));
		assertThat(response.getBody().get(1).getEndDate()).isEqualTo(LocalDateTime.of(2020, 06, 15, 11, 00, 00));
		assertThat(response.getBody().get(1).getPrice()).isEqualTo(30.5);
	}
	
	@Test
	void getPricesFiltered5() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<List<PriceDto>> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            new ParameterizedTypeReference<List<PriceDto>>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isNotEmpty();
		assertThat(response.getBody().size()).isEqualTo(2);
		assertThat(response.getBody().get(0).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(0).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(0).getPriceList()).isEqualTo(1);
		assertThat(response.getBody().get(0).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().get(0).getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().get(0).getPrice()).isEqualTo(35.50);
		assertThat(response.getBody().get(1).getProductId()).isEqualTo(productId);
		assertThat(response.getBody().get(1).getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().get(1).getPriceList()).isEqualTo(4);
		assertThat(response.getBody().get(1).getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 15, 16, 00, 00));
		assertThat(response.getBody().get(1).getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().get(1).getPrice()).isEqualTo(38.95);
	}

}
