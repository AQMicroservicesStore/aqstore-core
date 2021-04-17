package com.aqstore.service.exception.http;

import com.aqstore.service.exception.AbstractAQStoreException;

public class AQStoreBadRequestException extends AbstractAQStoreException{
	
	public AQStoreBadRequestException(String errorCode, String errorMessage, Object... errorParams) {
		super(errorCode, errorMessage, errorParams);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7820403552022799560L;


}
