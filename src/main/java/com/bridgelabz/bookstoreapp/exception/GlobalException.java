package com.bridgelabz.bookstoreapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = UserRegistrationException.class)
	public ResponseEntity<Object> exception(UserRegistrationException exception) {
		return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
   }
	
	@ExceptionHandler(value = NullPointerException.class)
	public String exception(NullPointerException exception) {
		return "NullPointerException";
   }
	
	@ExceptionHandler(value = Exception.class)
	public String handleAnyException(){
		return "Exception";
   }
	
		
}
