package com.employee.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.AgeException;
import com.employee.exception.NameException;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(NameException.class)
	public ResponseEntity<Object> notFound(NameException ne){
		return new ResponseEntity<>("Name not found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> notValid(AgeException ae){
		return new ResponseEntity<Object>("Age is above 45",HttpStatus.NOT_FOUND);
	}
	
}
