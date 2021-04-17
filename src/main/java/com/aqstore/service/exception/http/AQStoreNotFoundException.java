package com.aqstore.service.exception.http;

import com.aqstore.service.exception.AbstractAQStoreException;

public class AQStoreNotFoundException extends AbstractAQStoreException{
	
	public AQStoreNotFoundException(String errorCode, String errorMessage, Object... errorParams) {
		super(errorCode, errorMessage, errorParams);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7820403552022799560L;

	
}



