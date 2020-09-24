package com.cg.flight.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flight.dao.BookingDao;
import com.cg.flight.entity.Booking;
import com.cg.flight.exceptions.InvalidBookingException;
//import com.cg.flight.service.BookingService;
import com.cg.flight.service.FlightBookingService;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class BookingWebService {

	@Autowired
	private FlightBookingService bookingService;
	

	public List<Booking> bookFlight(@PathVariable("src") String src,@PathVariable("dest")String dest,@PathVariable("doj") @DateTimeFormat(pattern="yyyy-M-d") LocalDate doj) throws InvalidBookingException{

		return bookFlight(src, dest, doj);
	}
}