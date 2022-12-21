package com.flight.exceptions;

public class UsersAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public UsersAlreadyExistsException(String message) {
		super(message);
	}

	public UsersAlreadyExistsException() {}
}
