package com.flight.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passengerid")
	private int passengerId;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Flight flight;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Booking booking;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "age")
	private int age;
	@Column(name = "passportno")
	private String passportNo;

	public Passenger() {
		super();
	}

	public Passenger(int passengerId, Flight flight, Booking booking, String firstName, String lastName, String gender,
			int age, String passportNo) {
		super();
		this.passengerId = passengerId;
		this.flight = flight;
		this.booking = booking;
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
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
	public int hashCode() {
		return Objects.hash(age, booking, firstName, flight, gender, lastName, passengerId, passportNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return age == other.age && Objects.equals(booking, other.booking) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(flight, other.flight) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && passengerId == other.passengerId
				&& Objects.equals(passportNo, other.passportNo);
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", flight=" + flight + ", booking=" + booking + ", firstName="
				+ firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age + ", passportNo="
				+ passportNo + "]";
	}

}
