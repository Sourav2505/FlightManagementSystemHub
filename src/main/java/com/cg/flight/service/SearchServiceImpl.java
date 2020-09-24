package com.cg.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

//import org.checkerframework.common.reflection.qual.NewInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flight.dao.ScheduledFlightDao;
import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.util.FlightConstants;

@Service
public class SearchServiceImpl implements SearchService {

	private Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	@Autowired
	private ScheduledFlightDao searchDao;

	@Override
	public List<ScheduledFlight> searchFlights(String src, String dest, LocalDate doj) throws SearchException {
        List<ScheduledFlight> flist= searchDao.searchflight(src, dest);
        if(flist.isEmpty())
        	throw new SearchException(FlightConstants.FLIGHT_NOT_AVAILABLE);
        
		flist = flist.stream().filter(schflight->schflight.getArrivalTime().toLocalDate().equals(doj)).collect(Collectors.toList());
		 if(flist.isEmpty())
	        	throw new SearchException(FlightConstants.FLIGHT_NOT_AVAILABLE);
		flist.sort((sf1, sf2)->Double.valueOf(sf1.getFare()).compareTo(sf2.getFare()) );
        return flist;
	}

	

}
