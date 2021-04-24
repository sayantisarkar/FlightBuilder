package com.sayantisarkar.connectionBuilder.repository;

import org.springframework.data.repository.CrudRepository;

import com.sayantisarkar.connectionBuilder.model.Flight;


public interface FlightRepository extends CrudRepository<Flight, Long> {
	
}
