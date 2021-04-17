package com.aqstore.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aqstore.service.exception.http.AQStoreBadRequestException;
import com.aqstore.service.exception.http.AQStoreInternalServerErrorException;
import com.aqstore.service.exception.http.AQStoreNotFoundException;
import com.aqstore.service.exception.http.AQStoreUnauthorizedException;
import com.aqstore.service.exception.model.AQStoreErrorModel;

public interface IAQStoreControllerAdvice<ERROR> {

	
	ERROR convertToDTO(AQStoreErrorModel error);
	
	
	@ExceptionHandler(AQStoreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)	
	default ERROR handleNotFound(AQStoreNotFoundException ex) {
		return convertToDTO(ex.getErrorModel());

    }
	
	@ExceptionHandler(AQStoreUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)	
	default ERROR handleUnauthorized(AQStoreUnauthorizedException ex) {
		return convertToDTO(ex.getErrorModel());
    }
	
	
	@ExceptionHandler(AQStoreBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)	
	default ERROR handleBadRequest(AQStoreBadRequestException ex) {
		return convertToDTO(ex.getErrorModel());

    }
	
	@ExceptionHandler(AQStoreInternalServerErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)	
	default ERROR handleInternalServerError(AQStoreInternalServerErrorException ex) {
		return convertToDTO(ex.getErrorModel());

    }

	@ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)	
	default ERROR handleContstraintValidation(ConstraintViolationException ex) {
		List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach( c-> {
        		String errorMessage ="";
        		if(c.getPropertyPath()!= null && c.getPropertyPath() instanceof PathImpl) {
        			PathImpl p= (PathImpl)c.getPropertyPath();
        			errorMessage = p.getLeafNode().asString().concat(" : ");
        		}
        		errors.add(errorMessage.concat(c.getMessage()));
		});
		AQStoreErrorModel errorModel = AQStoreErrorModel.builder()
				.datetime(Instant.now())
				.errorCode("0400")
				.errors(errors)
				.build();
		return convertToDTO(errorModel);
    }
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)	
	default ERROR handleBadValidation(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String value = error.getDefaultMessage();
            errors.add(field.concat(":").concat(value));            
        });
		AQStoreErrorModel errorModel = AQStoreErrorModel.builder()
				.datetime(Instant.now())
				.errorCode("0400")
				.errors(errors)
				.build();
		return convertToDTO(errorModel);
    }
	
	
	
	
	
}
