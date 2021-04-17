package com.aqstore.service.exception.model;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AQStoreErrorModel {

	
	private Instant datetime;
	private String errorCode;
	private List<String> errors;
	
}
