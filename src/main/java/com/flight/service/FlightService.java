package com.flight.service;

import java.util.List;

import com.flight.dto.FlightDTO;
import com.flight.entities.FlightDetails;
import com.flight.exceptions.FlightAlreadyExistsException;
import com.flight.exceptions.FlightNotFoundException;

public interface FlightService {

	public List<FlightDTO> getAllFlight();

	public FlightDTO getFlightById(Integer flightId) throws FlightNotFoundException;

	public Integer addFlight(FlightDTO flight) throws FlightAlreadyExistsException;

	public void updateFlight(Integer flightId, String flightName, int fare) throws FlightNotFoundException;

	public void deleteFlightById(Integer flightId);

	public FlightDetails addFlightDetails(FlightDetails flightDetails);

}
