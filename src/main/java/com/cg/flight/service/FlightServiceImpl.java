package com.cg.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.flight.entity.Passenger;
import com.cg.flight.dao.FlightDao;
import com.cg.flight.entity.Booking;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.util.ContactConstants;
import com.cg.flight.util.IDConstants;

@Service
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDao bdao;
	@Override
	public List<Booking> viewBookings(String num) throws SearchException {
		List<Booking> blist=bdao.viewBookings(num);
		if(blist.isEmpty())
			throw new SearchException(ContactConstants.USER_NOT_FOUND);
		return blist;
		
	}
	@Override
	public List<Passenger> viewPassengers(String id) throws SearchException {
		List<Passenger> plist=bdao.viewPassengers(id);
		if(plist.isEmpty())
			throw new SearchException(IDConstants.ID_NOT_FOUND);
		return plist;
	}

}
