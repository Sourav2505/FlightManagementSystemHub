package com.cg.flight.service;

import java.util.List;

import com.cg.flight.entity.Passenger;
import com.cg.flight.entity.Booking;
import com.cg.flight.exceptions.SearchException;

public interface FlightService {
	public List<Booking> viewBookings(String num)throws SearchException;
	public List<Passenger> viewPassengers(String id)throws SearchException;
}
