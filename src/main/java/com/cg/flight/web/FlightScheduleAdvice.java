package com.cg.flight.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flight.dto.ScheduleErrorMessage;
import com.cg.flight.exceptions.AirportException;
import com.cg.flight.exceptions.FlightException;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;

@RestControllerAdvice
public class FlightScheduleAdvice {
	
	@ExceptionHandler(AirportException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ScheduleErrorMessage handleAirportException(AirportException ex) {
		return new ScheduleErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
		
	}
	@ExceptionHandler(FlightException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ScheduleErrorMessage handleFlightException(FlightException ex) {
		return new ScheduleErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	@ExceptionHandler(ScheduledIdNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ScheduleErrorMessage handleScheduledIdNotFoundException(ScheduledIdNotFoundException ex) {
		return new ScheduleErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	@ExceptionHandler(LoginException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ScheduleErrorMessage handleLoginException(LoginException ex) {
		return new ScheduleErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
}
