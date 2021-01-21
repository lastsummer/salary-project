package com.e104.salary.exception;

import org.springframework.http.HttpStatus;

public class CustomStatusException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private HttpStatus statusCode;
	// 參數錯誤
	public CustomStatusException(String message, HttpStatus statusCode) {
		super(message);
		this.statusCode = statusCode;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
}
