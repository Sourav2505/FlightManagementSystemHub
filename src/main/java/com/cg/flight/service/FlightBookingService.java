package com.cg.flight.service;

import com.cg.flight.dto.BookingDto;
import com.cg.flight.entity.Passenger;
import com.cg.flight.exceptions.InvalidBookingException;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;


public interface FlightBookingService {
	public String addBooking(BookingDto bookingForm)throws InvalidBookingException, ScheduledIdNotFoundException, LoginException;
	
}