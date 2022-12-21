package com.flight;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.flight.dao.BookingDAO;
import com.flight.dto.BookingDTO;
import com.flight.entities.Booking;
import com.flight.exceptions.BookingAlreadyExistsException;
import com.flight.service.BookingServiceImpl;

class TestBooking {

	@InjectMocks
	BookingServiceImpl BookingServiceImpl;

	@Mock
	BookingDAO dao;
	@Mock
	BookingDTO dto;

	@SuppressWarnings({ "deprecation" })
	@Test
	void createBookingTest() throws BookingAlreadyExistsException {
		MockitoAnnotations.initMocks(this);
		Booking bookingEntity = new Booking();
		bookingEntity.setBookingId(2);
		bookingEntity.setFlightStatus("Booked");
		bookingEntity.setTotalCost(15000);
		BookingServiceImpl.addBooking(dto);
	}
}