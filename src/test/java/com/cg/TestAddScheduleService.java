package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flight.dto.ScheduleDto;
import com.cg.flight.exceptions.AirportException;
import com.cg.flight.exceptions.FlightException;
import com.cg.flight.exceptions.ScheduledIdNotFoundException;
import com.cg.flight.service.FlightScheduleService;

@SpringBootTest
public class TestAddScheduleService {
	
	@Autowired
	private FlightScheduleService flightService;
	
	@Test
	public void testAddSchedule() throws AirportException, FlightException, ScheduledIdNotFoundException {
		String expected = "KG-101" + LocalDateTime.of(2020, 10, 01, 12, 00).toString();
		ScheduleDto dto = new ScheduleDto(55,LocalDateTime.of(2020, 10, 01, 12, 00), 60, "estimated", 3500, "MAA", "DEL", "KG-101");
		String actual = flightService.addFlightSchedule(dto);
		assertEquals(expected, actual);
	}
	@Test
	public void testAddSchedule2() throws AirportException, FlightException{
		ScheduleDto dto = new ScheduleDto(55,LocalDateTime.of(2020, 10, 15, 12, 00), 70, "estimated", 5500, "MAA", "DL", "KG");
		assertThrows(AirportException.class, ()-> flightService.addFlightSchedule(dto));
	}
	@Test
	public void testAddSchedule3() throws FlightException, AirportException{
		ScheduleDto dto = new ScheduleDto(98,LocalDateTime.of(2020, 10, 04, 12, 00), 120, "estimated", 4500, "DEL", "MAA", "AG");
		assertThrows(FlightException.class, ()-> flightService.addFlightSchedule(dto));
	}


}
