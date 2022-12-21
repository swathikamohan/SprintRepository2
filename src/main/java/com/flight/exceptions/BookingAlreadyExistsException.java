package com.flight.exceptions;

public class BookingAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	public BookingAlreadyExistsException(String message) {
		super();
	}
	
	public BookingAlreadyExistsException() {}
}
