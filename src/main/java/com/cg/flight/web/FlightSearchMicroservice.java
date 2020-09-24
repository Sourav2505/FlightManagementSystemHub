package com.cg.flight.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.service.SearchService;
import com.cg.flight.util.FlightConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FlightSearchMicroservice {

	@Autowired
	private SearchService searchService;
	
	@GetMapping(FlightConstants.SEARCH_URL)
	public List<ScheduledFlight> searchFlight(@PathVariable("src") String src,@PathVariable("dest")String dest,@PathVariable("doj") @DateTimeFormat(pattern="yyyy-M-d") LocalDate doj) throws SearchException{
		return searchService.searchFlights(src, dest, doj);
	}
	
	
}
