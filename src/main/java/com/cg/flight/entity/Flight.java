package com.cg.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "flight_details")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Flight {
	
	@Id
	@Column(name = "flight_code", length = 10)
	private String flightCode;
	
	@Column(name = "flight_name", length = 30)
	private String flightName;
	
	@Column(name = "seat_capacity", length = 30)
	private String seatCapacity;
	
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public Flight(String flightCode, String flightName, String seatCapacity) {
		super();
		this.flightCode = flightCode;
		this.flightName = flightName;
		this.seatCapacity = seatCapacity;
	}
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return flightCode + " " + flightName + " " + seatCapacity;
	}
	

}
