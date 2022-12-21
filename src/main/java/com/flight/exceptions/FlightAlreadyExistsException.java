package com.flight.exceptions;

public class FlightAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public FlightAlreadyExistsException(String message) {
		super(message);
	}

	public FlightAlreadyExistsException() {}

}
