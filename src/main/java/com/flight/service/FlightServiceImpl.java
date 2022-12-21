package com.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.FlightDAO;
import com.flight.dao.FlightDetailsDAO;
import com.flight.dto.FlightDTO;
import com.flight.entities.Flight;
import com.flight.entities.FlightDetails;
import com.flight.exceptions.FlightAlreadyExistsException;
import com.flight.exceptions.FlightNotFoundException;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDAO flightDao;
	@Autowired
	private FlightDetailsDAO flightDetailsDao;

	@Override
	public List<FlightDTO> getAllFlight() {
		Iterable<Flight> flight = flightDao.findAll();
		List<FlightDTO> flightList = new ArrayList<>();
		flight.forEach(t -> {
			FlightDTO f = new FlightDTO();
			f.setFlightId(t.getFlightId());
			f.setFlightName(t.getFlightName());
			f.setFare(t.getFare());
			f.setFlightdetails(t.getFlightdetails());
			f.setPassenger(t.getPassenger());
			flightList.add(f);
		});
		return flightList;
	}

	@Override
	public FlightDTO getFlightById(Integer flightId) throws FlightNotFoundException {
		Optional<Flight> optional = flightDao.findById(flightId);
		Flight flight = optional.orElseThrow(() -> new FlightNotFoundException("Service.FLIGHT_NOT_FOUND"));
		FlightDTO flight2 = new FlightDTO();
		flight2.setFlightId(flight.getFlightId());
		flight2.setFlightName(flight.getFlightName());
		flight2.setFare(flight.getFare());
		flight2.setFlightdetails(flight.getFlightdetails());
		flight2.setPassenger(flight.getPassenger());
		return flight2;
	}

	@Override
	public Integer addFlight(FlightDTO flight) throws FlightAlreadyExistsException {
		if (flightDao.findById(flight.getFlightId()).isEmpty()) {
			Flight flightEntity = new Flight();
			flightEntity.setFlightId(flight.getFlightId());
			flightEntity.setFlightName(flight.getFlightName());
			flightEntity.setFare(flight.getFare());
			Flight flightEntity2 = flightDao.save(flightEntity);
			return flightEntity2.getFlightId();
		} else {
			throw new FlightAlreadyExistsException();
		}
	}

	@Override
	public void updateFlight(Integer flightId, String flightName, int fare) throws FlightNotFoundException {
		Optional<Flight> optional = flightDao.findById(flightId);
		Flight f = optional.orElseThrow(() -> new FlightNotFoundException("Service.FLIGHT_NOT_FOUND"));
		f.setFlightId(flightId);
		f.setFlightName(flightName);
		f.setFare(fare);
		flightDao.save(f);
	}

	@Override
	public void deleteFlightById(Integer flightId) {
		flightDao.deleteById(flightId);
	}

	@Override
	public FlightDetails addFlightDetails(FlightDetails flightDetails) {
		return flightDetailsDao.save(flightDetails);
	}

}
