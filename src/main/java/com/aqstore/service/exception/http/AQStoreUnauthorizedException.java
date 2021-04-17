package com.aqstore.service.exception.http;

import com.aqstore.service.exception.AbstractAQStoreException;

public class AQStoreUnauthorizedException extends AbstractAQStoreException{
	
	public AQStoreUnauthorizedException(String errorCode, String errorMessage, Object... errorParams) {
		super(errorCode, errorMessage, errorParams);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7820403552022799560L;


	
}



