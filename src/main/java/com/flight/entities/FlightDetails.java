package com.flight.entities;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "flightdetails")
public class FlightDetails {

	@OneToOne
	@PrimaryKeyJoinColumn
	private Flight flight;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	@Column(name = "departure")
	private String departure;
	@Column(name = "arrival")
	private String arrival;
	@Column(name = "departuredate")
	private LocalDate departureDate;
	@Column(name = "arrivaldate")
	private LocalDate arrivalDate;
	@Column(name = "totalseats")
	private int totalSeats;
	@Column(name = "remainingseats")
	private int remainingSeats;

	public FlightDetails() {
		super();

	}

	public FlightDetails(Flight flight, int flightId, String departure, String arrival, LocalDate departureDate,
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
	public int hashCode() {
		return Objects.hash(arrival, arrivalDate, departure, departureDate, flight, flightId, remainingSeats,
				totalSeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDetails other = (FlightDetails) obj;
		return Objects.equals(arrival, other.arrival) && Objects.equals(arrivalDate, other.arrivalDate)
				&& Objects.equals(departure, other.departure) && Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(flight, other.flight) && flightId == other.flightId
				&& remainingSeats == other.remainingSeats && totalSeats == other.totalSeats;
	}

	@Override
	public String toString() {
		return "FlightDetails [flight=" + flight + ", flightId=" + flightId + ", departure=" + departure + ", arrival="
				+ arrival + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", totalSeats="
				+ totalSeats + ", remainingSeats=" + remainingSeats + "]";
	}

}