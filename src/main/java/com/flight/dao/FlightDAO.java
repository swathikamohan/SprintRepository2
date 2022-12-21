package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.Flight;

public interface FlightDAO extends JpaRepository<Flight, Integer> {

}
