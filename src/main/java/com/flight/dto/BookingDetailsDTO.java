package com.flight.dto;

import com.flight.entities.Flight;

public class BookingDetailsDTO {

	private int bookingId;
	private Flight flight;

	public BookingDetailsDTO() {
		super();
	}

	public BookingDetailsDTO(int bookingId, Flight flight) {
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
		return "BookingDetailsDTO [bookingId=" + bookingId + ", flight=" + flight + "]";
	}

}
