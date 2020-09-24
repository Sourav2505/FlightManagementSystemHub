package com.cg.flight.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flight.dto.BookingDto;
import com.cg.flight.dto.FlightMessage;
import com.cg.flight.exceptions.InvalidBookingException;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;
import com.cg.flight.service.FlightBookingService;
import com.cg.flight.util.BookingConstants;

@RestController
public class FlightBookingtRestController {

	@Autowired
	private FlightBookingService service;
	
	@CrossOrigin
	@PostMapping(BookingConstants.ADD_BOOKING_URL)
	public FlightMessage addBooking(@RequestBody BookingDto bookingForm) throws InvalidBookingException, ScheduledIdNotFoundException, LoginException {
		//After implementing the login, the uncomment it
		//if(!(boolean)req.getAttribute("authFlag"))throw new UserException(FlightConstants.NOT_AUTHENTICATED);
		String bookingID =service.addBooking(bookingForm);
		FlightMessage msg = new FlightMessage();
		msg.setMessage(bookingID);
		return msg;
	}
	
	
}
