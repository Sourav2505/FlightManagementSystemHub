package com.cg.flight.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flight.dao.BookingDao;
import com.cg.flight.dao.ScheduledFlightDao;
import com.cg.flight.entity.Booking;
import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.InvalidBookingException;
import com.cg.flight.util.ErrorConstants;
@Service()
@Transactional
public class CancelTicketBookingImpl implements CancelTicketBookingService {
@Autowired
BookingDao bookingDao;
@Autowired
ScheduledFlightDao scheduleflightdao;
	@Override
	public boolean deleteBooking(String bookingId) throws InvalidBookingException {
		
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			Booking booking=findBookingById.get();
			if(booking.getSchedule().getArrivalTime().toLocalDate().isAfter(LocalDate.now()))
				throw new InvalidBookingException(ErrorConstants.NOT_CANCELLED); 
			booking.setBookingStatus(ErrorConstants.BOOKING_CANCEL);
			bookingDao.save(booking);
			ScheduledFlight schedule=booking.getSchedule();
			schedule.setAvailableSeats( schedule.getAvailableSeats() - booking.getNoOfSeats());
			return true;
		} else
			throw new InvalidBookingException(ErrorConstants.BOOKING_NOT_FOUND);
}
}
		
