package com.flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.BookingDAO;
import com.flight.dao.BookingDetailsDAO;
import com.flight.dto.BookingDTO;
import com.flight.dto.BookingDetailsDTO;
import com.flight.entities.Booking;
import com.flight.entities.BookingDetails;
import com.flight.exceptions.BookingAlreadyExistsException;
import com.flight.exceptions.BookingNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDao;

	@Autowired
	private BookingDetailsDAO bookingDetailsDao;

	@Override
	public List<BookingDTO> getAllBooking() {
		Iterable<Booking> booking = bookingDao.findAll();
		List<BookingDTO> bookingList = new ArrayList<>();
		booking.forEach(t -> {
			BookingDTO b = new BookingDTO();
			b.setBookingId(t.getBookingId());
			b.setBookingDate(t.getBookingDate());
			b.setFlightStatus(t.getFlightStatus());
			b.setTotalCost(t.getTotalCost());
			b.setTravelDate(t.getTravelDate());
			bookingList.add(b);
		});
		return bookingList;
	}

	@Override
	public BookingDTO getBookingById(Integer bookingId) throws BookingNotFoundException {
		Optional<Booking> optional = bookingDao.findById(bookingId);
		Booking booking = optional.orElseThrow(() -> new BookingNotFoundException("Service.BOOKING_NOT_FOUND"));
		BookingDTO b = new BookingDTO();
		b.setBookingId(booking.getBookingId());
		b.setBookingDate(booking.getBookingDate());
		b.setFlightStatus(booking.getFlightStatus());
		b.setTotalCost(booking.getTotalCost());
		b.setTravelDate(booking.getTravelDate());
		return b;
	}

	@Override
	public void addBooking(BookingDTO booking) throws BookingAlreadyExistsException {
		if (bookingDao.findById(booking.getBookingId()).isEmpty()) {
			Booking bookingEntity = new Booking();
			bookingEntity.setBookingId(booking.getBookingId());
			bookingEntity.setBookingDate(booking.getBookingDate());
			bookingEntity.setFlightStatus(booking.getFlightStatus());
			bookingEntity.setTotalCost(booking.getTotalCost());
			bookingEntity.setTravelDate(booking.getTravelDate());
			bookingDao.save(bookingEntity);

		} else {
			throw new BookingAlreadyExistsException();
		}
	}

	@Override
	public void updateBooking(Integer bookingId, LocalDate bookingDate, LocalDate travelDate, String flightStatus,
			int totalCost) throws BookingNotFoundException {
		Optional<Booking> optional = bookingDao.findById(bookingId);
		Booking b = optional.orElseThrow(() -> new BookingNotFoundException("Service.BOOKING_NOT_FOUND"));
		b.setBookingId(bookingId);
		b.setBookingDate(bookingDate);
		b.setFlightStatus(flightStatus);
		b.setTotalCost(totalCost);
		b.setTravelDate(travelDate);
		bookingDao.save(b);
	}

	@Override
	public void deleteBookingById(Integer bookingId) {
		bookingDao.deleteById(bookingId);
	}

	@Override
	public List<BookingDetailsDTO> getBookingDetails() {
		Iterable<BookingDetails> bookingDetails = bookingDetailsDao.findAll();
		List<BookingDetailsDTO> bookingDetailsList = new ArrayList<>();
		bookingDetails.forEach(t -> {
			BookingDetailsDTO b = new BookingDetailsDTO();
			b.setBookingId(t.getBookingId());
			b.setFlight(t.getFlight());
			bookingDetailsList.add(b);
		});
		return bookingDetailsList;
	}

}
