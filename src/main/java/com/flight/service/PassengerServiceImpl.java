package com.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.PassengerDAO;
import com.flight.dto.PassengerDTO;
import com.flight.entities.Passenger;
import com.flight.exceptions.PassengerAlreadyExistsException;
import com.flight.exceptions.PassengerNotFoundException;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDAO passengerDao;

	@Override
	public List<PassengerDTO> getAllPassenger() {
		Iterable<Passenger> passenger = passengerDao.findAll();
		List<PassengerDTO> passengerList = new ArrayList<>();
		passenger.forEach(t -> {
			PassengerDTO p = new PassengerDTO();
			p.setFlight(t.getFlight());
			p.setBooking(t.getBooking());
			p.setPassengerId(t.getPassengerId());
			p.setAge(t.getAge());
			p.setFirstName(t.getFirstName());
			p.setLastName(t.getLastName());
			p.setGender(t.getGender());
			p.setPassportNo(t.getPassportNo());
			passengerList.add(p);
		});

		return passengerList;
	}

	@Override
	public PassengerDTO getPassengerById(Integer passengerId) throws PassengerNotFoundException {
		Optional<Passenger> optional = passengerDao.findById(passengerId);
		Passenger passenger = optional.orElseThrow(() -> new PassengerNotFoundException("Service.PASSENGER_NOT_FOUND"));
		PassengerDTO passenger2 = new PassengerDTO();
		passenger2.setFlight(passenger.getFlight());
		passenger2.setBooking(passenger.getBooking());
		passenger2.setPassengerId(passenger.getPassengerId());
		passenger2.setAge(passenger.getAge());
		passenger2.setFirstName(passenger.getFirstName());
		passenger2.setGender(passenger.getGender());
		passenger2.setLastName(passenger.getLastName());
		passenger2.setPassportNo(passenger.getPassportNo());
		return passenger2;
	}

	@Override
	public void addPassenger(PassengerDTO passenger) throws PassengerAlreadyExistsException {
		Passenger passengerEntity = new Passenger();
		if (passengerDao.findById(passenger.getPassengerId()).isEmpty()) {
			passengerEntity.setPassengerId(passenger.getPassengerId());
			passengerEntity.setAge(passenger.getAge());
			passengerEntity.setFirstName(passenger.getFirstName());
			passengerEntity.setGender(passenger.getGender());
			passengerEntity.setLastName(passenger.getLastName());
			passengerEntity.setPassportNo(passenger.getPassportNo());
			passengerDao.save(passengerEntity);
		} else {
			throw new PassengerAlreadyExistsException();
		}
	}

	@Override
	public void updatePassenger(Integer passengerId, int age, String firstName, String gender, String lastName,
			String passportNo) throws PassengerNotFoundException {
		Optional<Passenger> optional = passengerDao.findById(passengerId);
		Passenger p = optional.orElseThrow(() -> new PassengerNotFoundException("Service.PASSENGER_NOT_FOUND"));
		p.setPassengerId(passengerId);
		p.setAge(age);
		p.setFirstName(firstName);
		p.setGender(gender);
		p.setLastName(lastName);
		p.setPassportNo(passportNo);
		passengerDao.save(p);

	}

	@Override
	public void deletePassengerById(Integer passengerId) {
		passengerDao.deleteById(passengerId);

	}

}
