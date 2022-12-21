package com.flight.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookingdetails")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int bookingId;
	@OneToOne
	@JoinColumn(name = "flightid")
	private Flight flight;

	public BookingDetails() {
		super();
	}

	public BookingDetails(int bookingId, Flight flight) {
		super();
		this.bookingId = bookingId;
		this.flight = flight;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", flight=" + flight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, flight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDetails other = (BookingDetails) obj;
		return bookingId == other.bookingId && Objects.equals(flight, other.flight);
	}

}