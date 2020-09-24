package com.cg.flight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flight.entity.Booking;
import com.cg.flight.entity.Flight;
import com.cg.flight.entity.Passenger;

@Repository
public interface FlightDao extends JpaRepository<Flight, String>{

	
	@Query("from Flight where flightCode=:flightid")
	public Flight getFlight(@Param("flightid") String flight);
	@Query(value = "from Booking b inner join fetch b.user u where u.contactNo=:cnum")
	public List<Booking> viewBookings(@Param("cnum") String num);
	@Query(value = "from Passenger p inner join fetch p.booking b where b.bookingId=:bid")
	public List<Passenger> viewPassengers(@Param("bid") String id);
	
}
