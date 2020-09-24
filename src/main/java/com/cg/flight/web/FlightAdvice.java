package com.cg.flight.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flight.dto.FlightErrorMessage;
import com.cg.flight.exceptions.SearchException;

@RestControllerAdvice
public class FlightAdvice {

	@ExceptionHandler(SearchException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public FlightErrorMessage handleSearchException(SearchException ex) {
		return new FlightErrorMessage(HttpStatus.NOT_FOUND.toString(),ex.getMessage(), LocalDateTime.now().toString());
	}
}
