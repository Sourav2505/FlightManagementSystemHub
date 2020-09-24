package com.cg.flight.service;

import com.cg.flight.exceptions.InvalidBookingException;

public interface CancelTicketBookingService {
	public boolean deleteBooking(String bookingId)throws InvalidBookingException;

}
