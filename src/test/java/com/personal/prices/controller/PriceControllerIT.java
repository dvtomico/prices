package com.personal.prices.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
	void getPricesFiltered1_OK() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<PriceDto> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            PriceDto.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getProductId()).isEqualTo(productId);
		assertThat(response.getBody().getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().getPriceList()).isEqualTo(1);
		assertThat(response.getBody().getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().getPrice()).isEqualTo(35.50);
	}
	
	@Test
	void getPricesFiltered2_OK() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 14, 16, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<PriceDto> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            PriceDto.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getProductId()).isEqualTo(productId);
		assertThat(response.getBody().getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().getPriceList()).isEqualTo(2);
		assertThat(response.getBody().getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 15, 00, 00));
		assertThat(response.getBody().getEndDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 18, 30, 00));
		assertThat(response.getBody().getPrice()).isEqualTo(25.45);
	}
	
	@Test
	void getPricesFiltered3_OK() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 14, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<PriceDto> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            PriceDto.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getProductId()).isEqualTo(productId);
		assertThat(response.getBody().getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().getPriceList()).isEqualTo(1);
		assertThat(response.getBody().getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		assertThat(response.getBody().getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().getPrice()).isEqualTo(35.50);
	}
	
	@Test
	void getPricesFiltered4_OK() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<PriceDto> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            PriceDto.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getProductId()).isEqualTo(productId);
		assertThat(response.getBody().getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().getPriceList()).isEqualTo(3);
		assertThat(response.getBody().getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 15, 00, 00, 00));
		assertThat(response.getBody().getEndDate()).isEqualTo(LocalDateTime.of(2020, 06, 15, 11, 00, 00));
		assertThat(response.getBody().getPrice()).isEqualTo(30.50);
	}
	
	@Test
	void getPricesFiltered5_OK() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<PriceDto> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            PriceDto.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getProductId()).isEqualTo(productId);
		assertThat(response.getBody().getBrandId()).isEqualTo(brandId);
		assertThat(response.getBody().getPriceList()).isEqualTo(4);
		assertThat(response.getBody().getStartDate()).isEqualTo(LocalDateTime.of(2020, 06, 15, 16, 00, 00));
		assertThat(response.getBody().getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(response.getBody().getPrice()).isEqualTo(38.95);
	}
	
	@Test
	void getPricesFiltered_KO_missingProductIdParameter() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&brandId=" + brandId;
		
		ResponseEntity<String> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isEqualTo("The parameter productId is required");
	}
	
	@Test
	void getPricesFiltered_KO_missingBrandIdParameter() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId;
		
		ResponseEntity<String> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isEqualTo("The parameter brandId is required");
	}
	
	@Test
	void getPricesFiltered_KO_missingApplicationDateTimeParameter() {
		
		String url = URL_BASE
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<String> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isEqualTo("The parameter applicationDateTime is required");
	}
	
	@Test
	void getPricesFiltered_KO_invalidLocationDateTimeType() {
		String applicationDateTime = "2020/12/12 12:12:12";
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=" + productId
				+ "&brandId=" + brandId;
		
		ResponseEntity<String> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isEqualTo("The parameter applicationDateTime must be a LocalDateTime");
	}
	
	@Test
	void getPricesFiltered_KO_priceNotFound() {
		LocalDateTime applicationDateTime = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		
		String url = URL_BASE
				+ "applicationDateTime=" + applicationDateTime
				+ "&productId=123"
				+ "&brandId=" + brandId;
		
		ResponseEntity<String> response =
		        restTemplate.exchange(url,
		            HttpMethod.GET, null,
		            String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isEqualTo("Price not found");
	}

}
