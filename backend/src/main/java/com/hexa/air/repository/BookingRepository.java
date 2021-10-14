package com.hexa.air.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hexa.air.entity.Booking;

public interface BookingRepository  extends CrudRepository<Booking, String>{
	
	@Query("SELECT b from Booking b WHERE b.passengerId =:passenger_Id")
	List<Booking> getBookings(@Param("passenger_Id") String passenger_Id);

}
