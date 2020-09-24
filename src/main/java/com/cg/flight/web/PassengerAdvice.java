package com.cg.flight.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flight.dto.IDErrorMessage;
import com.cg.flight.exceptions.SearchException;
@RestControllerAdvice
public class PassengerAdvice {
	@ExceptionHandler(SearchException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public IDErrorMessage handleSearchException(SearchException ex) {
		return new IDErrorMessage(HttpStatus.NOT_FOUND.toString(),ex.getMessage(),LocalDateTime.now().toString());
		
	}
}
