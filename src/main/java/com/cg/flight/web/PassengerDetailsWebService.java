package com.cg.flight.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flight.entity.Passenger;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.service.FlightService;
import com.cg.flight.util.IDConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PassengerDetailsWebService {
	@Autowired
	private FlightService passService;
	@GetMapping(IDConstants.SEARCH_URL)
	public List<Passenger> viewPassengers(@PathVariable("bid") String id)throws SearchException{
		return passService.viewPassengers(id);
	}
}
