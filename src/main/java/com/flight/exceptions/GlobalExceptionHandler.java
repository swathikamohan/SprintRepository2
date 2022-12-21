package com.flight.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = FlightNotFoundException.class)
	public ResponseEntity<String> flightNotFound(FlightNotFoundException e) {
		return new ResponseEntity<>("Flight Not Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UsersNotFoundException.class)
	public ResponseEntity<String> usersNotFound(UsersNotFoundException e) {
		return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BookingNotFoundException.class)
	public ResponseEntity<String> bookingNotFound(BookingNotFoundException e) {
		return new ResponseEntity<>("Booking Not Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PassengerNotFoundException.class)
	public ResponseEntity<String> passengerNotFound(PassengerNotFoundException e) {
		return new ResponseEntity<>("Passenger Not Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = FlightAlreadyExistsException.class)
	public ResponseEntity<String> flightAlreadyExists(FlightAlreadyExistsException e) {
		return new ResponseEntity<>("Flight Already Exists", HttpStatus.FOUND);
	}

	@ExceptionHandler(value = PassengerAlreadyExistsException.class)
	public ResponseEntity<String> passengerAlreadyExists(PassengerAlreadyExistsException e) {
		return new ResponseEntity<>("Passenger Already Exists", HttpStatus.FOUND);
	}

	@ExceptionHandler(value = UsersAlreadyExistsException.class)
	public ResponseEntity<String> usersAlreadyExists(UsersAlreadyExistsException e) {
		return new ResponseEntity<>("Users Already Exists", HttpStatus.FOUND);
	}

	@ExceptionHandler(value = BookingAlreadyExistsException.class)
	public ResponseEntity<String> bookingAlreadyExists(BookingAlreadyExistsException e) {
		return new ResponseEntity<>("Booking Already Exists", HttpStatus.FOUND);
	}
}
