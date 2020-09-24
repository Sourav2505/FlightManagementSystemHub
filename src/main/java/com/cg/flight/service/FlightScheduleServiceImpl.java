package com.cg.flight.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flight.dao.AirportDao;
import com.cg.flight.dao.FlightDao;
import com.cg.flight.dao.ScheduledFlightDao;
import com.cg.flight.dto.ScheduleDto;
import com.cg.flight.entity.Airport;
import com.cg.flight.entity.Flight;
import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.AirportException;
import com.cg.flight.exceptions.FlightException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;
import com.cg.flight.util.ScheduleConstants;

/************************************************************************************
 *          @author          Sourav Singh
 *          Description      It is a service class that provides the services for 
 *                           adding flight schedule and cancel flight schedule 
 *
 *         Created Date    22-SEP-2020
 ************************************************************************************/

@Service("myservice")
@Transactional
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	private FlightDao flightDao;
	@Autowired
	private AirportDao airportDao;
	@Autowired
	private ScheduledFlightDao scheduledflightDao;
	
	/************************************************************************************
	 * Method: addFlightSchedule
     * Description: To add the flight schedules details
	 * @param schedule - it has ScheduleDto type and having schedule details from database
	 * 
	 * @returns String - Schedule id created and return the schedule id.
	 * @throws AirportException - as it occurs when airports are not found and 
	 *                            source and  destination airports are same
	 * @throws FlightExcetion: It occurs when flightId is not found 
	 * @throws ScheduledIdNotFoundException - it occurs when schedule id is already
	 *                                        exist in the database
     * Created By                              - Sourav Singh
     * Created Date                            - 22-SEP-2020                           
	
	 ************************************************************************************/
	
	@Override
	public String addFlightSchedule(ScheduleDto schedule)
			throws AirportException, FlightException, ScheduledIdNotFoundException {
	
			String scheduledFlightId = schedule.getFlightId() + schedule.getDepartureTime();
			Optional<ScheduledFlight> scheduleFlightopt = scheduledflightDao.findById(scheduledFlightId);
			if (scheduleFlightopt.isPresent())
				throw new ScheduledIdNotFoundException(ScheduleConstants.SCHID_EXIST);
			if(schedule.getSrcAirport().equalsIgnoreCase(schedule.getDstAirport()))
				throw new AirportException(ScheduleConstants.SRC_DST_SAME);

			ScheduledFlight scheduledflight = new ScheduledFlight();
			scheduledflight.setScheduledFlightId(scheduledFlightId);
			scheduledflight.setAvailableSeats(schedule.getAvailableSeats());
			scheduledflight.setDepartureTime(schedule.getDepartureTime());
			scheduledflight.setArrivalTime(schedule.getDepartureTime().plusMinutes(schedule.getMinutes()));
			scheduledflight.setMinutes(schedule.getMinutes());			
			scheduledflight.setScheduleStatus(schedule.getScheduleStatus());
			scheduledflight.setFare(schedule.getFare());
			
			Airport srcairport = null;
			srcairport = airportDao.getAirport(schedule.getSrcAirport());
			if (srcairport == null)
				throw new AirportException(ScheduleConstants.AIRPORT_NOT_AVAILABLE);
			Airport dstairport = null;
			dstairport = airportDao.getAirport(schedule.getDstAirport());
			if (dstairport == null)
				throw new AirportException(ScheduleConstants.AIRPORT_NOT_AVAILABLE);
			Flight flight = null;
			flight = flightDao.getFlight(schedule.getFlightId());
			if (flight == null)
				throw new FlightException(ScheduleConstants.FLIGHT_NOT_AVAILABLE);
			
			scheduledflight.setSourceAirport(srcairport);
			scheduledflight.setDestinationAirport(dstairport);
			scheduledflight.setFlight(flight);
			ScheduledFlight scheduledFlight = scheduledflightDao.save(scheduledflight);

			return scheduledFlight.getScheduledFlightId();
	
	}
	
	/************************************************************************************
	 * Method: cancelFlightSchedule
     * Description: To cancel the flight schedules details
	 * @param schFlightId - it is String type	 * 
	 * @returns String - Returns the message when we cancel the schedule.	 
	 * @throws ScheduledIdNotFoundException - it occurs when schedule id is not
	 *                                        exist in the database
     * Created By                              - Sourav Singh
     * Created Date                            - 22-SEP-2020                           
	
	 ************************************************************************************/

	@Override
	public String cancelFlightSchedule(String schFlightId) throws ScheduledIdNotFoundException {
		if (schFlightId == null)
			throw new ScheduledIdNotFoundException(ScheduleConstants.ENTER_FLIGHT_ID);
		Optional<ScheduledFlight> scheduleFlightopt = scheduledflightDao.findById(schFlightId);
		if (!scheduleFlightopt.isPresent())
			throw new ScheduledIdNotFoundException(ScheduleConstants.SCH_ID_NOT_FOUND);
		else {
		   
			ScheduledFlight schedule=scheduleFlightopt.get();
			schedule.setScheduleStatus(ScheduleConstants.FLIGHT_CANCELLED);
			scheduledflightDao.save(schedule);
			
		}
		return ScheduleConstants.CANCELLED_SUCCESSFULLY + schFlightId;
	}

	
		
}