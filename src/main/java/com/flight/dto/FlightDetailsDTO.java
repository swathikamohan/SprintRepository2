package com.flight.dto;

import java.time.LocalDate;
import com.flight.entities.Flight;

public class FlightDetailsDTO {

	private Flight flight;
	private int flightId;
	private String departure;
	private String arrival;
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private int totalSeats;
	private int remainingSeats;

	public FlightDetailsDTO() {
		super();
	}

	public FlightDetailsDTO(Flight flight, int flightId, String departure, String arrival, LocalDate departureDate,
			LocalDate arrivalDate, int totalSeats, int remainingSeats) {
		super();
		this.flight = flight;
		this.flightId = flightId;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.totalSeats = totalSeats;
		this.remainingSeats = remainingSeats;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;

	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	@Override
	public String toString() {
		return "FlightDetailsDTO [flight=" + flight + ", flightId=" + flightId + ", departure=" + departure
				+ ", arrival=" + arrival + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate
				+ ", totalSeats=" + totalSeats + ", remainingSeats=" + remainingSeats + "]";
	}

}
