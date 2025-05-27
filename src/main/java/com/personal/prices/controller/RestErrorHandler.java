package com.personal.prices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.personal.prices.exception.PriceNotFoundException;

@ControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public ResponseEntity<String> processMissingParameter(MissingServletRequestParameterException ex) {
		return new ResponseEntity<>("The parameter " + ex.getParameterName() + " is required", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseBody
	public ResponseEntity<String> processTypeMismatch(MethodArgumentTypeMismatchException ex) {
		return new ResponseEntity<>("The parameter " + ex.getName() + " must be a " + ex.getRequiredType().getSimpleName(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PriceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<String> processNotFound(PriceNotFoundException ex) {
		return new ResponseEntity<>("Price not found", HttpStatus.NOT_FOUND);
	}

}
