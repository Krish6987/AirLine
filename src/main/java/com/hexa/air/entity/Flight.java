package com.hexa.air.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Flight")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Flight implements Serializable{

	@Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "FlightNumber", nullable = false, length=5)
	private String FlightNumber;
	@Column(name = "Name")
	private String Name;
	@Column(name = "DepartureCity")
	private String DepartureCity;
	@Column(name = "DestinationCity")
	private String DestinationCity;
	@Column(name = "DepartureDate")
	private String DepartureDate;
	@Column(name = "DepartureTime")
	private String DepartureTime;
	@Column(name = "ArrivalDate")
	private String ArrivalDate;
	@Column(name = "ArrivalTime")
	private String ArrivalTime;
	@Column(name = "BusinessClassSeats")
	private int BusinessClassSeats;
	@Column(name = "EconomyClassSeats")
	private int EconomyClassSeats;
	@Column(name = "BusinessClassPrice")
	private int BusinessClassPrice;
	@Column(name = "EconomyClassPrice")
	private int EconomyClassPrice;
	
	public String getFlightNumber() {
		return FlightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartureCity() {
		return DepartureCity;
	}
	public void setDepartureCity(String departureCity) {
		DepartureCity = departureCity;
	}
	public String getDestinationCity() {
		return DestinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		DestinationCity = destinationCity;
	}
	public String getDepartureDate() {
		return DepartureDate;
	}
	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}
	public String getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}
	public String getArrivalDate() {
		return ArrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		ArrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public int getBusinessClassSeats() {
		return BusinessClassSeats;
	}
	public void setBusinessClassSeats(int businessClassSeats) {
		BusinessClassSeats = businessClassSeats;
	}
	public int getEconomyClassSeats() {
		return EconomyClassSeats;
	}
	public void setEconomyClassSeats(int economyClassSeats) {
		EconomyClassSeats = economyClassSeats;
	}
	public int getBusinessClassPrice() {
		return BusinessClassPrice;
	}
	public void setBusinessClassPrice(int businessClassPrice) {
		BusinessClassPrice = businessClassPrice;
	}
	public int getEconomyClassPrice() {
		return EconomyClassPrice;
	}
	public void setEconomyClassPrice(int economyClassPrice) {
		EconomyClassPrice = economyClassPrice;
	}
	@Override
	public String toString() {
		return "Flight [FlightNumber=" + FlightNumber + ", Name=" + Name + ", DepartureCity=" + DepartureCity
				+ ", DestinationCity=" + DestinationCity + ", DepartureDate=" + DepartureDate + ", DepartureTime="
				+ DepartureTime + ", ArrivalDate=" + ArrivalDate + ", ArrivalTime=" + ArrivalTime
				+ ", BusinessClassSeats=" + BusinessClassSeats + ", EconomyClassSeats=" + EconomyClassSeats
				+ ", BusinessClassPrice=" + BusinessClassPrice + ", EconomyClassPrice=" + EconomyClassPrice + "]";
	}
	
	
	
}
