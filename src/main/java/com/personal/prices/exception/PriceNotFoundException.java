package com.personal.prices.exception;

public class PriceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PriceNotFoundException(String message) {
		super(message);
	}

}
