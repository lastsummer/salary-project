package com.e104.salary.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
		ExceptionResponse exceptionResource= new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResource, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomStatusException.class)
	protected ResponseEntity<Object> handleCustomExceptions(CustomStatusException ex, WebRequest request) {
		ExceptionResponse exceptionResource= new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResource, ex.getStatusCode());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errorMessage = "";
        for (final ObjectError error : ex.getBindingResult().getAllErrors()) {
        	errorMessage += ","+error.getDefaultMessage();
        }
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),errorMessage, ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
