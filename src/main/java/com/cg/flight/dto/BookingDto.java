package com.cg.flight.dto;

import java.util.ArrayList;
import java.util.List;

import com.cg.flight.entity.Passenger;

public class BookingDto {

	private int tkts;
	private String scheduleFlightId;
	private String contactNo;
	private List<Passenger> passengers = new ArrayList<>();
	
	
	public BookingDto(int tkts, String scheduleFlightId, String contactNo, List<Passenger> passengers) {
		super();
		this.tkts = tkts;
		this.scheduleFlightId = scheduleFlightId;
		this.contactNo = contactNo;
		this.passengers = passengers;
	}
	public int getTkts() {
		return tkts;
	}
	public void setTkts(int tkts) {
		this.tkts = tkts;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public String getScheduleFlightId() {
		return scheduleFlightId;
	}
	public void setScheduleFlightId(String scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	}