package com.aqstore.service.exception.http;

import com.aqstore.service.exception.AbstractAQStoreException;

public class AQStoreInternalServerErrorException extends AbstractAQStoreException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7820403552022799560L;

	public AQStoreInternalServerErrorException(Exception e) {
		super("ISE0","Internal Server Error -  exception : %s  - message : %s", e.getClass().getSimpleName(),e.getMessage());
	}
	

	
	public AQStoreInternalServerErrorException(String code, String message, Object... args) {
		super(code, message, args);
	}


}
