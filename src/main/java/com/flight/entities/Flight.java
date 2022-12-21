package com.flight.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class Flight {

	@OneToOne(mappedBy = "flight")
	@JsonIgnore
	private FlightDetails flightdetails;
	@OneToOne(mappedBy = "flight")
	@JsonIgnore
	private Passenger passenger;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flightid")
	private int flightId;
	@Column(name = "flightname")
	private String flightName;
	@Column(name = "fare")
	private int fare;

	public Flight() {
		super();
	}

	public Flight(int flightId, String flightName, int fare) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.fare = fare;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public FlightDetails getFlightdetails() {
		return flightdetails;
	}

	public void setFlightdetails(FlightDetails flightdetails) {
		this.flightdetails = flightdetails;
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
		return "Flight [flightdetails=" + flightdetails + ", passenger=" + passenger + ", flightId=" + flightId
				+ ", flightName=" + flightName + ", fare=" + fare + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fare, flightId, flightName, flightdetails, passenger);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return fare == other.fare && flightId == other.flightId && Objects.equals(flightName, other.flightName)
				&& Objects.equals(flightdetails, other.flightdetails) && Objects.equals(passenger, other.passenger);
	}

}
