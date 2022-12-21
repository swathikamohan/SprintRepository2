package com.flight.dto;

import com.flight.entities.Booking;
import com.flight.entities.Flight;

public class PassengerDTO {

	private int passengerId;
	private Booking booking;
	private Flight flight;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String passportNo;

	public PassengerDTO() {
		super();
	}

	public PassengerDTO(int passengerId, Flight flight, Booking booking, String firstName, String lastName,
			String gender, int age, String passportNo) {
		super();
		this.passengerId = passengerId;
		this.booking = booking;
		this.flight = flight;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.passportNo = passportNo;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Override
	public String toString() {
		return "PassengerDTO [passengerId=" + passengerId + ", booking=" + booking + ", flight=" + flight
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age
				+ ", passportNo=" + passportNo + "]";
	}

}
