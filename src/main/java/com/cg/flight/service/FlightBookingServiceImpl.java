package com.cg.flight.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.flight.dao.BookingDao;

import com.cg.flight.dao.PassengerDao;
import com.cg.flight.dao.ScheduledFlightDao;
import com.cg.flight.dao.UserDao;
import com.cg.flight.dto.BookingDto;
import com.cg.flight.entity.Booking;
import com.cg.flight.entity.Passenger;
import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.entity.User;
import com.cg.flight.exceptions.InvalidBookingException;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;
import com.cg.flight.util.BookingConstants;
import com.cg.flight.util.ScheduleConstants;

@Service
@Transactional
public class FlightBookingServiceImpl implements FlightBookingService {

	@Autowired
	private BookingDao dao;
	
@Autowired
	private ScheduledFlightDao schdao;

@Autowired
private UserDao userdao;

@Autowired
private PassengerDao passengerdao;

	@Transactional
	@Override
	public String addBooking(BookingDto bookingForm) throws InvalidBookingException, ScheduledIdNotFoundException, LoginException {
       ScheduledFlight schflight =  schdao.viewFlightSchedule(bookingForm.getScheduleFlightId());
       if(schflight==null) throw new ScheduledIdNotFoundException(BookingConstants.SCHEDULE_NOT_FOUND);
       User user = userdao.viewUser(bookingForm.getContactNo());
       if(user==null) throw new LoginException(BookingConstants.USER_NOT_FOUND); 
       Booking booking = null;
       String bookingId="";
       if(schflight.getAvailableSeats() >= bookingForm.getTkts()) {
    	   booking = new Booking();
    	   booking.setBookingDate(LocalDate.now());
    	   bookingId = bookingForm.getScheduleFlightId()+generateBookingId(bookingForm.getScheduleFlightId());
    	   booking.setBookingId(bookingId);
    	   booking.setFare(schflight.getDynamicPrice()* bookingForm.getTkts());
    	   booking.setNoOfSeats(bookingForm.getTkts());
    	   booking.setSchedule(schflight);
    	   booking.setUser(user);
    	   dao.save(booking);
    	   schflight.setAvailableSeats(schflight.getAvailableSeats() - bookingForm.getTkts());
    	  schdao.save(schflight);
    	  schdao.flush();
    	  addPassenger(bookingForm.getPassengers(), booking);
    	   return bookingId;
       }
		throw new InvalidBookingException(BookingConstants.BOOKING_NOT_AVAILABLE);
		
	}

	
	private int generateBookingId(String scheduleFlightId) {
	int count=dao.countBookingbyschedule(scheduleFlightId)+BookingConstants.INCREMENT_BY_ONE;
		return count;
	}


	public boolean addPassenger(List<Passenger> passengers, Booking booking) {
      passengers.forEach(passenger->{passenger.setBooking(booking);passengerdao.save(passenger);});
		
		return true;
	}
	
}