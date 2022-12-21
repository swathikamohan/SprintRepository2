package com.flight.entities;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int bookingId;
	@Column(name = "bookingdate")
	private LocalDate bookingDate;
	@Column(name = "traveldate")
	private LocalDate travelDate;
	@Column(name = "flightstatus")
	private String flightStatus;
	@Column(name = "totalcost")
	private int totalCost;

	public Booking() {
		super();
	}

	public Booking(int bookingId, LocalDate bookingDate, LocalDate travelDate, String flightStatus, int totalCost) {
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
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", travelDate=" + travelDate
				+ ", flightStatus=" + flightStatus + ", totalCost=" + totalCost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, flightStatus, totalCost, travelDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
				&& Objects.equals(flightStatus, other.flightStatus) && totalCost == other.totalCost
				&& Objects.equals(travelDate, other.travelDate);
	}

}
