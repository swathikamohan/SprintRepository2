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
import com.flight.dto.PassengerDTO;
import com.flight.exceptions.PassengerAlreadyExistsException;
import com.flight.exceptions.PassengerNotFoundException;
import com.flight.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping(value = "/Passengers")
	public ResponseEntity<List<PassengerDTO>> getAllPassenger() {
		List<PassengerDTO> passengerList = passengerService.getAllPassenger();
		return new ResponseEntity<>(passengerList, HttpStatus.OK);
	}

	@GetMapping(value = "/Passengers/{passengerId}")
	public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable Integer passengerId)
			throws PassengerNotFoundException {
		PassengerDTO passengerList1 = passengerService.getPassengerById(passengerId);
		return new ResponseEntity<>(passengerList1, HttpStatus.OK);
	}

	@PostMapping(value = "/Passengers")
	public ResponseEntity<String> addPassenger(@RequestBody PassengerDTO passenger)
			throws PassengerAlreadyExistsException {
		passengerService.addPassenger(passenger);
		return new ResponseEntity<>("Passenger Added Successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/Passengers/{passengerId}")
	public ResponseEntity<String> updatePassenger(@PathVariable Integer passengerId,
			@RequestBody PassengerDTO passenger) throws PassengerNotFoundException {
		passengerService.updatePassenger(passengerId, passenger.getAge(), passenger.getFirstName(),
				passenger.getGender(), passenger.getLastName(), passenger.getPassportNo());
		return new ResponseEntity<>("Passenger Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/Passengers/{passengerId}")
	public ResponseEntity<String> deletePassenger(@PathVariable Integer passengerId) {
		passengerService.deletePassengerById(passengerId);
		return new ResponseEntity<>("Passenger Deleted Successfully", HttpStatus.OK);
	}
}
