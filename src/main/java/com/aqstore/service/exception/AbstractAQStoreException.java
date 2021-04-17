package com.aqstore.service.exception;

import java.time.Instant;
import java.util.Arrays;

import com.aqstore.service.exception.model.AQStoreErrorModel;

public abstract class AbstractAQStoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386763825805525191L;
	private String errorCode;

	public AbstractAQStoreException(String errorCode, String errorMessage, Object... errorParams) {
		super(String.format(errorMessage, errorParams));
		this.errorCode = errorCode;
	}

	public String getErrorCode() {	
		return errorCode;
	}
	

	public AQStoreErrorModel getErrorModel() {
		return AQStoreErrorModel.builder()
		.datetime(Instant.now())
		.errorCode(getErrorCode())
		.errors(Arrays.asList(getMessage()))
		.build();
	}
	
	
	
}
