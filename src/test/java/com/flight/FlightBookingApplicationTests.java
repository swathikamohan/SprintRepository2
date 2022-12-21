package com.flight;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flight.dao.FlightDAO;
import com.flight.entities.Flight;

@SpringBootTest
class FlightBookingApplicationTests {

	@Autowired
	private FlightDAO flightdao;

	@Test
	void addflight() {
		new Flight(1, "King Flyer", 25000);
		assertNotNull(flightdao.findById(1).get());
	} 	
	
}
