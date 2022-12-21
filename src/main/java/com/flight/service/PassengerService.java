package com.flight.service;

import java.util.List;
import com.flight.dto.PassengerDTO;
import com.flight.exceptions.PassengerAlreadyExistsException;
import com.flight.exceptions.PassengerNotFoundException;

public interface PassengerService {

	public List<PassengerDTO> getAllPassenger();

	public PassengerDTO getPassengerById(Integer passengerId) throws PassengerNotFoundException;

	public void addPassenger(PassengerDTO passenger) throws PassengerAlreadyExistsException;
	
	public void updatePassenger(Integer passengerId, int age, String firstName, String gender, String lastName,
			String passportNo) throws PassengerNotFoundException;

	public void deletePassengerById(Integer passengerId);
}
