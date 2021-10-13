package com.hexa.air.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexa.air.entity.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, String> {

	@Modifying
	@Transactional
	@Query("UPDATE Flight f SET f.EconomyClassSeats = f.EconomyClassSeats - :seats WHERE Flight_Number = :Flight_Number")
	public void updateEconomySeats(@Param("Flight_Number") String flight_number, @Param("seats")int seats);
	@Modifying
	@Transactional
	@Query("UPDATE Flight f SET f.BusinessClassSeats = f.BusinessClassSeats - :seats WHERE Flight_Number = :Flight_Number")
	public void updateBusinessSeats(@Param("Flight_Number") String flight_number, @Param("seats")int seats);
	@Query("SELECT f from Flight f where f.DepartureCity =:Departure_City AND f.DestinationCity =:Destination_City AND f.DepartureDate =:Departure_Date AND f.BusinessClassSeats >= :Seats")
	List<Flight> findByFilterBusiness(@Param("Departure_City") String Departure_City, @Param("Destination_City") String Destination_City, @Param("Departure_Date") String Departure_Date, @Param("Seats") int Seats);
	@Query("SELECT f from Flight f where f.DepartureCity =:Departure_City AND f.DestinationCity =:Destination_City AND f.DepartureDate =:Departure_Date AND f.EconomyClassSeats >= :Seats")
	List<Flight> findByFilterEconomy(@Param("Departure_City") String Departure_City, @Param("Destination_City") String Destination_City, @Param("Departure_Date") String Departure_Date, @Param("Seats") int Seats);
	
}
