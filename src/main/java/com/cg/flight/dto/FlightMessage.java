package com.cg.flight.dto;

public class FlightMessage {
	private String message;

	public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}

	public FlightMessage(String message) {
		super();
		this.message = message;
	}
	public FlightMessage() {
		super();
	}

}
