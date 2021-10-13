package com.hexa.air.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "FLIGHT")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Flight {

	@Id
	@Column(name="FlightNumber", length=5)
	String FlightNumber;
	@NotNull
	@Column(name="Name", length=10)
	String Name;
	@NotNull
	@Column(name="DepartureCity", length=20)
	String DepartureCity;
	@Column(name="DestinationCity", length=20)
	@NotNull
	String DestinationCity;
	@Column(name="DepartureDate", length=20)
	@NotNull
	String DepartureDate;
	@Column(name="DepartureTime", length=20)
	@NotNull
	String DepartureTime;
	@Column(name="ArrivalDate", length=20)
	@NotNull
	String ArrivalDate;
	@Column(name="ArrivalTime", length=20)
	@NotNull
	String ArrivalTime;
	@Column(name="BusinessClassSeats")
	@NotNull
	int BusinessClassSeats;
	@Column(name="EconomyClassSeats")
	@NotNull
	int EconomyClassSeats;
	@Column(name="BusinessClassPrice")
	@NotNull
	int BusinessClassPrice;
	@Column(name="EconomyClassPrice")
	@NotNull
	int EconomyClassPrice;
	
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
