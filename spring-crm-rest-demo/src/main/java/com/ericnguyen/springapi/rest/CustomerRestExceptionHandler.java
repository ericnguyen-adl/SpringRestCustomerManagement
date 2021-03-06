package com.ericnguyen.springapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	// Add exception handler for CustomerNotFoundException 
	@ExceptionHandler 
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		// create CustomerErrorResponse 
		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(); 
		customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		customerErrorResponse.setMessage(exc.getMessage());
		customerErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity 		
		return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);  
	}
	
	// add another exception handler to catch for any exception 
	@ExceptionHandler 
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
		// create CustomerErrorResponse 
		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(); 
		customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		customerErrorResponse.setMessage(exc.getMessage());
		customerErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity 		
		return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);  
	}
	

}
