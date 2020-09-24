package com.cg.flight.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDto {
	
	private Integer availableSeats;
	@JsonFormat(pattern = "yyyy-M-d HH:mm")
	@DateTimeFormat(pattern = "yyyy-M-d HH:mm")
	private LocalDateTime arrivalTime;
	private int minutes;
	@JsonFormat(pattern = "yyyy-M-d HH:mm")
	@DateTimeFormat(pattern = "yyyy-M-d HH:mm")
    private LocalDateTime departureTime;
	private String scheduleStatus;
	private double fare;
	private String srcAirport;
	private String dstAirport;
	private String flightId;
	
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public ScheduleDto() {
		super();
	}
	public ScheduleDto(Integer availableSeats, LocalDateTime departureTime, int minutes,
			String scheduleStatus, double fare, String srcAirport, String dstAirport, String flightId) {
		super();
		this.availableSeats = availableSeats;
		this.arrivalTime = arrivalTime;
		this.minutes = minutes;
		this.departureTime = departureTime;
		this.scheduleStatus = scheduleStatus;
		this.fare = fare;
		this.srcAirport = srcAirport;
		this.dstAirport = dstAirport;
		this.flightId = flightId;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public String getScheduleStatus() {
		return scheduleStatus;
	}
	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getSrcAirport() {
		return srcAirport;
	}
	public void setSrcAirport(String srcAirport) {
		this.srcAirport = srcAirport;
	}
	public String getDstAirport() {
		return dstAirport;
	}
	public void setDstAirport(String dstAirport) {
		this.dstAirport = dstAirport;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	
}

