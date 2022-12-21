package com.flight.dto;

import com.flight.entities.FlightDetails;
import com.flight.entities.Passenger;

public class FlightDTO {

	FlightDetails flightdetails;
	private Passenger passenger;
	private int flightId;
	private String flightName;
	private int fare;

	public FlightDTO() {
		super();
	}

	public FlightDTO(int flightId, String flightName, int fare) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.fare = fare;
	}

	public FlightDetails getFlightdetails() {
		return flightdetails;
	}

	public void setFlightdetails(FlightDetails flightdetails) {
		this.flightdetails = flightdetails;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightdetails=" + flightdetails + ", passenger=" + passenger + ", flightId=" + flightId
				+ ", flightName=" + flightName + ", fare=" + fare + "]";
	}

}
