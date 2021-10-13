package com.hexa.air.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.air.entity.Flight;
import com.hexa.air.repository.FlightRepository;

@Service
public class BookingService {
	
	@Autowired
	FlightRepository flightRepository;

	public List<Flight> getFlight(String DepartureCity, String DestinationCity, String DepartureDate, int seats) {
		
		return flightRepository.findByFilter(DepartureCity, DestinationCity, DepartureDate);
		
	}
}
