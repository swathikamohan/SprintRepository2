package com.flight.service;

import java.time.LocalDate;
import java.util.List;

import com.flight.dto.BookingDTO;
import com.flight.dto.BookingDetailsDTO;
import com.flight.exceptions.BookingAlreadyExistsException;
import com.flight.exceptions.BookingNotFoundException;

public interface BookingService {

	public List<BookingDTO> getAllBooking();

	public BookingDTO getBookingById(Integer bookingId) throws BookingNotFoundException;

	public void addBooking(BookingDTO booking) throws BookingAlreadyExistsException;

	public void updateBooking(Integer bookingId, LocalDate bookingDate, LocalDate travelDate, String flightStatus,
			int totalCost) throws BookingNotFoundException;

	public void deleteBookingById(Integer bookingId);

	public List<BookingDetailsDTO> getBookingDetails();
}
