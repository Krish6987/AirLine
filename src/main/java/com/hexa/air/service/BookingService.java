package com.hexa.air.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.air.entity.Booking;
import com.hexa.air.entity.Flight;
import com.hexa.air.repository.BookingRepository;
import com.hexa.air.repository.FlightRepository;

@Service
public class BookingService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	public List<Flight> getFlights(String DepartureCity, String DestinationCity, String DepartureDate, String type, int seats) {
		
		if(type.toLowerCase().equals("economy"))
			return flightRepository.findByFilterEconomy(DepartureCity, DestinationCity, DepartureDate, seats);
		if(type.toLowerCase().equals("business"))
			return flightRepository.findByFilterBusiness(DepartureCity, DestinationCity, DepartureDate, seats);
		return null;
		
	}
	
	public Object getFlight(String flightNumber) {
		if(flightRepository.existsById(flightNumber))
			return flightRepository.findById(flightNumber);
		return null;
	}
	
	public String bookFlight(String flight_number, String passengerId, String type, int seats, String passengerName, String address, String creditCard) {
		
		Booking booking = new Booking();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String dateTime = dtf.format(now).toString();
		dateTime = dateTime.replaceAll("/","");
		dateTime = dateTime.replaceAll(":", "");
		dateTime = dateTime.replaceAll(" ","");
		Random rand = new Random();
		int randomNum = rand.nextInt((5000 - 1) + 1) + 1;
		String confirmationNumber = dateTime+flight_number+randomNum;
		booking.setConfirmationNumber(confirmationNumber);
		booking.setFlightNumber(flight_number);
		booking.setPassengerId(passengerId);
		booking.setPassengerName(passengerName);
		booking.setType(type);
		booking.setSeats(seats);
		try {
			bookingRepository.save(booking);
			if(type.toLowerCase().equals("economy")){
				flightRepository.updateEconomySeats(flight_number, seats);
			}
			else if(type.toLowerCase().equals("business")){
				flightRepository.updateBusinessSeats(flight_number, seats);
			}
			return confirmationNumber;
		}
		
		catch(Exception e) {
			return "Booking Unsuccessful";
		}
	}
	public List<Booking> getBookings(String passengerId) {
		return bookingRepository.getBookings(passengerId);
	}
}
