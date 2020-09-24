package com.cg.flight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.flight.entity.ScheduledFlight;

@Repository
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, String>{
	@Query("from ScheduledFlight sf where sf.scheduledFlightId=:sid")
	public ScheduledFlight viewFlightSchedule(@Param("sid") String scheduleFlightId);
	
	@Query("from ScheduledFlight where scheduledFlightId=:sid ")
	public ScheduledFlight getSchedule(@Param("sid") String schedulId);
	
	@Query("from ScheduledFlight sf inner join fetch sf.sourceAirport sp inner join fetch sf.destinationAirport dp where sp.airportCode=:source and dp.airportCode=:destination")
	public List<ScheduledFlight> searchflight(@Param("source")String src, @Param("destination")String dest);

	

}
