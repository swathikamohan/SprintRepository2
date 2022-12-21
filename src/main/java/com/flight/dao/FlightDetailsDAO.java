package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.FlightDetails;

public interface FlightDetailsDAO extends JpaRepository<FlightDetails, Integer> {

}
