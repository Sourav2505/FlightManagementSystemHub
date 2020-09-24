package com.cg.flight.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="flight_schedule")
public class ScheduledFlight {
	
	@Id
	@Column(name="schedule_id")
	private String scheduledFlightId;
	@Column(name="avaialble_seats")
	private Integer availableSeats;
	@Column(name="arrival_time")
	@JsonFormat(pattern = "yyyy-M-d HH:mm")
	@DateTimeFormat(pattern = "yyyy-M-d HH:mm")
	private LocalDateTime arrivalTime;
	@Column(name="minutes")
	private int minutes;
	@Column(name="departure_time")
	@JsonFormat(pattern = "yyyy-M-d HH:mm")
	@DateTimeFormat(pattern = "yyyy-M-d HH:mm")
	private LocalDateTime departureTime;
	@Column(name="schedule_status")
	private String scheduleStatus;
	@Column(name="fare")
	private double fare;
	
	@Transient
	private double dynamicPrice;
	
	@ManyToOne
	@JoinColumn(name="src_airport", referencedColumnName = "airport_code")
	private Airport sourceAirport = new Airport();
	@ManyToOne
	@JoinColumn(name="dest_airport", referencedColumnName = "airport_code")
	private Airport destinationAirport = new Airport();
	@ManyToOne
	@JoinColumn(name="flight_code", referencedColumnName = "flight_code")
	private Flight flight = new Flight();
	
	public String getScheduledFlightId() {
		return scheduledFlightId;
	}
	public void setScheduledFlightId(String scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
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
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
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
	public double getDynamicPrice() {
		Period period = Period.between(LocalDate.now(), departureTime.toLocalDate());
		dynamicPrice = this.fare;
		if(period.getDays()<= 1) {
		      this.dynamicPrice = this.fare + this.fare * 0.50;
		}else if(period.getDays()<= 4)
			 this.dynamicPrice = this.fare + this.fare * 0.30;
		return dynamicPrice;
	}
	public void setDynamicPrice(double dynamicPrice) {
		this.dynamicPrice = dynamicPrice;
	}

}
