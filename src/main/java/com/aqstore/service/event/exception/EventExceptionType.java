package com.aqstore.service.event.exception;

import org.springframework.http.HttpStatus;

import com.aqstore.service.exception.AQStoreExceptionType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventExceptionType implements AQStoreExceptionType{
	
	EVENT_FAILED("WES1","Error while send event to 	TOPIC -> %s - ID_EVENT=[%s] - ID_PAYLOAD[%s] ",HttpStatus.INTERNAL_SERVER_ERROR),

	;
	
	@Getter private final String code;
	@Getter private final String message;
	@Getter private final HttpStatus httpStatus;



}
