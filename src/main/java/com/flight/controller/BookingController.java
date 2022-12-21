package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.BookingDTO;
import com.flight.dto.BookingDetailsDTO;
import com.flight.exceptions.BookingAlreadyExistsException;
import com.flight.exceptions.BookingNotFoundException;
import com.flight.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping(value = "/Bookings")
	public ResponseEntity<List<BookingDTO>> getAllBooking() {
		List<BookingDTO> bookingList = bookingService.getAllBooking();
		return new ResponseEntity<>(bookingList, HttpStatus.OK);
	}

	@GetMapping(value = "/Bookings/{bookingId}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException {
		BookingDTO bookingList2 = bookingService.getBookingById(bookingId);
		return new ResponseEntity<>(bookingList2, HttpStatus.OK);
	}

	@PostMapping(value = "/Bookings")
	public ResponseEntity<String> addBooking(@RequestBody BookingDTO booking) throws BookingAlreadyExistsException {
		bookingService.addBooking(booking);
		return new ResponseEntity<>("Booking Added Successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/Bookings/{bookingId}")
	public ResponseEntity<String> updateBooking(@PathVariable Integer bookingId, @RequestBody BookingDTO booking)
			throws BookingNotFoundException {
		bookingService.updateBooking(bookingId, booking.getBookingDate(), booking.getTravelDate(),
				booking.getFlightStatus(), booking.getTotalCost());
		return new ResponseEntity<>("Booking Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/Bookings/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable Integer bookingId) {
		bookingService.deleteBookingById(bookingId);
		return new ResponseEntity<>("Booking Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping(value = "/BookingDetails")
	public ResponseEntity<List<BookingDetailsDTO>> getBookingDetails() {
		List<BookingDetailsDTO> bookingDetailsList = bookingService.getBookingDetails();
		return new ResponseEntity<>(bookingDetailsList, HttpStatus.OK);
	}
}
