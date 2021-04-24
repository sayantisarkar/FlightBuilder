package com.sayantisarkar.connectionBuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sayantisarkar.connectionBuilder.model.ConnectionOutput;
import com.sayantisarkar.connectionBuilder.model.Flight;
import com.sayantisarkar.connectionBuilder.service.ScheduleService;

@RestController
public class ConnectionController {

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/flight-schedules")
	private ResponseEntity<List<Flight>> getFlightSchedules() {
		return new ResponseEntity<>(scheduleService.getFlightSchedules(), HttpStatus.OK);
	}

	@RequestMapping(path = "/flight-schedules/{depCode}/{arrCode}", method = RequestMethod.GET)
	public ResponseEntity<List<ConnectionOutput>> findConnectingFlights(@PathVariable String depCode,
			@PathVariable String arrCode) {
		return new ResponseEntity<>(scheduleService.findConnectingFlights(depCode, arrCode), HttpStatus.OK);
	}

}
