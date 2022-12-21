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

import com.flight.dto.FlightDTO;
import com.flight.entities.FlightDetails;
import com.flight.exceptions.FlightAlreadyExistsException;
import com.flight.exceptions.FlightNotFoundException;
import com.flight.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping(value = "/Flights")
	public ResponseEntity<List<FlightDTO>> getAllFlights() {
		List<FlightDTO> flightList = flightService.getAllFlight();
		return new ResponseEntity<>(flightList, HttpStatus.OK);
	}

	@GetMapping(value = "/Flights/{flightId}")
	public ResponseEntity<FlightDTO> getFlightById(@PathVariable Integer flightId) throws FlightNotFoundException {
		FlightDTO flightList1 = flightService.getFlightById(flightId);
		return new ResponseEntity<>(flightList1, HttpStatus.OK);
	}

	@PostMapping(value = "/Flights")
	public ResponseEntity<String> addFlight(@RequestBody FlightDTO flight) throws FlightAlreadyExistsException {
		flightService.addFlight(flight);
		return new ResponseEntity<>("Flight Added Successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/Flights/{flightId}")
	public ResponseEntity<String> updateFlight(@PathVariable Integer flightId, @RequestBody FlightDTO flight)
			throws FlightNotFoundException {
		flightService.updateFlight(flightId, flight.getFlightName(), flight.getFare());
		return new ResponseEntity<>("Flight Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/Flights/{flightId}")
	public ResponseEntity<String> deleteFlightById(@PathVariable Integer flightId) {
		flightService.deleteFlightById(flightId);
		return new ResponseEntity<>("Flight Deleted Successfully", HttpStatus.OK);
	}

	@PostMapping(value = "/FlightDetails")
	public ResponseEntity<String> addFlightDetails(@RequestBody FlightDetails flightDetails) {
		flightService.addFlightDetails(flightDetails);
		return new ResponseEntity<>("Flight Added Successfully", HttpStatus.CREATED);
	}

}
