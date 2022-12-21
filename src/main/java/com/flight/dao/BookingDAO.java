package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flight.entities.Booking;

public interface BookingDAO extends JpaRepository<Booking, Integer> {

}
