package com.cg.flight.service;

import org.springframework.stereotype.Service;

import com.cg.flight.dto.ScheduleDto;
import com.cg.flight.exceptions.AirportException;
import com.cg.flight.exceptions.FlightException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;

@Service
public interface FlightScheduleService {
	
	public String addFlightSchedule(ScheduleDto schedule) throws AirportException, FlightException,ScheduledIdNotFoundException;
	
	public String cancelFlightSchedule(String schFlightId) throws ScheduledIdNotFoundException;
	
}
