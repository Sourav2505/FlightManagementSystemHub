package com.cg.flight.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flight.dto.FlightMessage;
import com.cg.flight.dto.ScheduleErrorMessage;
import com.cg.flight.exceptions.InvalidBookingException;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;

@RestControllerAdvice
public class FlightBookingAdvice {

@ExceptionHandler(InvalidBookingException.class)
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public FlightMessage handleExecption(InvalidBookingException ex) {
	return new FlightMessage(ex.getMessage());
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
