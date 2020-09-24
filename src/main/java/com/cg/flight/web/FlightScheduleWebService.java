package com.cg.flight.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flight.dto.FlightMessage;
import com.cg.flight.dto.ScheduleDto;
import com.cg.flight.exceptions.AirportException;
import com.cg.flight.exceptions.FlightException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;
import com.cg.flight.service.FlightScheduleServiceImpl;
import com.cg.flight.util.ScheduleConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FlightScheduleWebService {
	Logger logger = LoggerFactory.getLogger(FlightScheduleWebService.class);
	@Autowired
	private FlightScheduleServiceImpl flightService;
	
	@PostMapping(ScheduleConstants.SEARCH_URL)
	public FlightMessage addFlightSchedule(@RequestBody ScheduleDto schedule) throws 
	          AirportException, FlightException, ScheduledIdNotFoundException {
		logger.info(schedule.getFlightId());
		String scheduledFlightId = flightService.addFlightSchedule(schedule);
		return new FlightMessage("Schedule is created and the scheduled Flight Id is " + scheduledFlightId);
		
	}
	@DeleteMapping(ScheduleConstants.SEARCH_URL1)
	public FlightMessage cancelFlightSchedule(@PathVariable("schFlightId") String schFlightId) throws ScheduledIdNotFoundException{
		return new FlightMessage(flightService.cancelFlightSchedule(schFlightId));
	}
	
}
