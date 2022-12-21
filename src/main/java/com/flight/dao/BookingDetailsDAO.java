package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.BookingDetails;

public interface BookingDetailsDAO extends JpaRepository<BookingDetails, Integer> {

}
