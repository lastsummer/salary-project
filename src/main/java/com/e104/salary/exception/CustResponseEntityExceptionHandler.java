package com.e104.salary.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResource exceptionResource= new ExceptionResource(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResource, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomStatusException.class)
	protected ResponseEntity<Object> handleCustomExceptions(CustomStatusException ex, WebRequest request) {
		ExceptionResource exceptionResource= new ExceptionResource(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResource, ex.getStatusCode());
	}

}
