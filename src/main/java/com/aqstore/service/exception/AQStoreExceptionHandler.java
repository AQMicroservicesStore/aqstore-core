package com.aqstore.service.exception;

import com.aqstore.service.exception.http.AQStoreBadRequestException;
import com.aqstore.service.exception.http.AQStoreInternalServerErrorException;
import com.aqstore.service.exception.http.AQStoreNotFoundException;
import com.aqstore.service.exception.http.AQStoreUnauthorizedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AQStoreExceptionHandler {


	public static AbstractAQStoreException handleException(Exception e) {
		log.error("Exeption error - {} - {}",e.getClass().getSimpleName(),e.getMessage());
		
		if(e instanceof AbstractAQStoreException) {
			return (AbstractAQStoreException)e;
		}else {
			return new AQStoreInternalServerErrorException(e);
		}
	}		
	
	
	
	
	public static AbstractAQStoreException handleException(AQStoreExceptionType t,Object ...args) {
		try {
			log.error("Exeption error - {} - {}",t.getCode(),String.format(t.getMessage(), args));
			switch(t.getHttpStatus()) {
			case BAD_REQUEST:
				return new AQStoreBadRequestException(t.getCode(),t.getMessage(), args);
			case NOT_FOUND:
				return new AQStoreNotFoundException(t.getCode(),t.getMessage(), args);
			case UNAUTHORIZED:
				return new AQStoreUnauthorizedException(t.getCode(),t.getMessage(), args);
			case INTERNAL_SERVER_ERROR:
			default:
				return new AQStoreInternalServerErrorException(t.getCode(),t.getMessage(), args);
			}	
		}catch (Exception e) {
			return handleException(e);
		}
	
	}
}
