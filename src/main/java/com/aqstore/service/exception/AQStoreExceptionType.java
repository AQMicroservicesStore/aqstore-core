package com.aqstore.service.exception;

import org.springframework.http.HttpStatus;

public interface AQStoreExceptionType {

	String getCode();
	String getMessage();
	HttpStatus getHttpStatus();
	
}