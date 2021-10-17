package com.hexa.air.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hexa.air.entity.Booking;
import com.hexa.air.entity.Flight;
import com.hexa.air.service.BookingService;

@CrossOrigin(origins = { "*" })
@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/getflights", method=RequestMethod.POST)
	public List<Flight> getFlights(@RequestBody ObjectNode objectNode) {
		String departure = objectNode.get("departure").asText();
		String destination = objectNode.get("destination").asText();
		String date = objectNode.get("date").asText();
		String type = objectNode.get("type").asText();
		int seats = objectNode.get("seats").asInt();
		return bookingService.getFlights(departure, destination, date, type, seats);
	}
	
	@RequestMapping(value = "/getflightdetails/{flightNumber}", method=RequestMethod.GET)
	public Object getFlightDetails(@PathVariable("flightNumber") String flightNumber) {
		return bookingService.getFlight(flightNumber);
	}
	
	@RequestMapping(value = "/bookflight", method=RequestMethod.POST)
	public String bookFlight(@RequestBody ObjectNode objectNode) {

		String flight_number = objectNode.get("flight_number").asText();
		String type = objectNode.get("type").asText();
		int seats = objectNode.get("seats").asInt();
		String passengerId = objectNode.get("id").asText();
		String passengerName = objectNode.get("passengerName").asText();
		String address = objectNode.get("address").asText(); 
		String creditCard = objectNode.get("creditCard").asText();
		int totalCost = objectNode.get("totalCost").asInt(); 
		return bookingService.bookFlight(flight_number, passengerId, type, seats, passengerName, address, creditCard, totalCost);
	}
	
	@RequestMapping(value = "/getbookings/{passengerId}", method=RequestMethod.GET)
	public List<Booking> getBookings(@PathVariable("passengerId") String passengerId) {
		return bookingService.getBookings(passengerId);
	}

}
