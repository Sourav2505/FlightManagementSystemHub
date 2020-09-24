package com.cg.flight.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flight.entity.Booking;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.service.FlightService;
import com.cg.flight.util.ContactConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookingHistoryWebService {
	@Autowired
	private FlightService bookService;
	@GetMapping(ContactConstants.SEARCH_URL)
	public List<Booking> viewBookings(@PathVariable("cnum") String num)throws SearchException{
		return bookService.viewBookings(num);
}
}