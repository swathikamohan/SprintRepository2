package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.Passenger;

public interface PassengerDAO extends JpaRepository<Passenger, Integer> {

}
