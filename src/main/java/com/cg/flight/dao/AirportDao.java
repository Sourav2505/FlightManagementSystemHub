package com.cg.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flight.entity.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport, String>{
	
	@Query("from Airport where airportCode=:sairport")
	public Airport getAirport(@Param("sairport") String sourceAirport);
	
}
