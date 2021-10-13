package com.hexa.air.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexa.air.entity.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, String> {

	@Query("SELECT f from Flight f where f.DepartureCity =:Departure_City AND f.DestinationCity =:Destination_City AND f.DepartureDate =:Departure_Date AND f.BusinessClassSeats >= :Seats")
	List<Flight> findByFilterBusiness(@Param("Departure_City") String Departure_City, @Param("Destination_City") String Destination_City, @Param("Departure_Date") String Departure_Date, @Param("Seats") int Seats);
	@Query("SELECT f from Flight f where f.DepartureCity =:Departure_City AND f.DestinationCity =:Destination_City AND f.DepartureDate =:Departure_Date AND f.EconomyClassSeats >= :Seats")
	List<Flight> findByFilterEconomy(@Param("Departure_City") String Departure_City, @Param("Destination_City") String Destination_City, @Param("Departure_Date") String Departure_Date, @Param("Seats") int Seats);
	
}
