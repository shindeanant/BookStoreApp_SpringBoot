package com.bridgelabz.bookstoreapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = UserRegistrationException.class)
	public ResponseEntity<Object> exception(UserRegistrationException exception) {
		return new ResponseEntity<>("Exception while processing REST Request", HttpStatus.BAD_REQUEST);
   }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
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
