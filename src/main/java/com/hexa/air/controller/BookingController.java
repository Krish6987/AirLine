package com.hexa.air.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hexa.air.entity.Flight;
import com.hexa.air.service.BookingService;

@CrossOrigin(origins = { "*" })
@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/getflightdetails", method=RequestMethod.POST)
	public List<Flight> getFlightDetails(@RequestBody ObjectNode objectNode) {
		String departure = objectNode.get("departure").asText();
		String destination = objectNode.get("destination").asText();
		String date = objectNode.get("date").asText();
		int seats = objectNode.get("seats").asInt();
		return bookingService.getFlight(departure, destination, date, seats);
	}

}
