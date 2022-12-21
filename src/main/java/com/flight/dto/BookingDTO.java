package com.flight.dto;

import java.time.LocalDate;

public class BookingDTO {

	private int bookingId;
	private LocalDate bookingDate;
	private LocalDate travelDate;
	private String flightStatus;
	private int totalCost;

	public BookingDTO() {
		super();
	}

	public BookingDTO(int bookingId, LocalDate bookingDate, LocalDate travelDate, String flightStatus, int totalCost) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.flightStatus = flightStatus;
		this.totalCost = totalCost;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", travelDate=" + travelDate
				+ ", flightStatus=" + flightStatus + ", totalCost=" + totalCost + "]";
	}

}
