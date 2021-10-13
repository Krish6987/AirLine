package com.hexa.air.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexa.air.entity.Flight;

public interface FlightRepository extends CrudRepository<Flight, String> {

//	@Query("SELECT f from FLIGHT f where f.DepartureCity =:DepartureCity AND f.DestinationCity =:DestinationCity AND f.DepartureDate =:DepartureDate")
//	List<Flight> findByFilter(@Param("DepartureCity") String DepartureCity, @Param("DestinationCity") String DestinationCity, @Param("DepartureDate") String DepartureDate);
}
