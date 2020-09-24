package com.cg.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flight.entity.Booking;

@Repository
	public interface BookingDao extends JpaRepository<Booking, String>{

@Query("select count(b.bookingId) from Booking b where b.schedule.scheduledFlightId=:sid")	
	public int countBookingbyschedule(@Param("sid")String schFlightId);

}