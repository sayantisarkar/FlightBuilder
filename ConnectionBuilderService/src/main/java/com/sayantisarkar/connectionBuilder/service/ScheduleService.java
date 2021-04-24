package com.sayantisarkar.connectionBuilder.service;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sayantisarkar.connectionBuilder.model.ConnectionOutput;
import com.sayantisarkar.connectionBuilder.model.Flight;
import com.sayantisarkar.connectionBuilder.repository.FlightRepository;

@Service
public class ScheduleService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private JdbcTemplate template;

	public List<Flight> getFlightSchedules() {
		// List<FlightSchedule> flightSchedules = new ArrayList<>();

		String sql = "SELECT * FROM FLIGHTSCHEDULESDATA";

		return template.query(sql, new BeanPropertyRowMapper<>(Flight.class));

		// flightRepository.findAll().forEach(flightSchedule->flightSchedules.add(flightSchedule));
		// return flightSchedules;

	}

	public List<ConnectionOutput> findConnectingFlights(String depCode, String arrCode) {
		// logic

		List<Flight> flightSchedulesList = getFlightSchedules();
		List<ConnectionOutput> connectionResults = new ArrayList<>();
		List<Flight> depFlights = new ArrayList<>();
		List<Flight> arrFlights = new ArrayList<>();

		List<String> connectingAirports = new ArrayList<>();
		flightSchedulesList.forEach(flightSchedule -> {
			if (flightSchedule.getDepAirport().equalsIgnoreCase(depCode)) {
				connectingAirports.add(flightSchedule.getArrAirport());
			}
		});
		flightSchedulesList.forEach(flightSchedule -> {
			if (flightSchedule.getArrAirport().equalsIgnoreCase(arrCode)
					&& connectingAirports.contains(flightSchedule.getDepAirport())) {
				arrFlights.add(flightSchedule);
			}
			if (flightSchedule.getDepAirport().equalsIgnoreCase(depCode)
					&& connectingAirports.contains(flightSchedule.getArrAirport())) {
				depFlights.add(flightSchedule);
			}
		});

		depFlights.forEach(depFlight -> {
			arrFlights.forEach(arrFlight -> {
				Time arrTime = depFlight.getArrTime();
				Time depTime = arrFlight.getDepTime();
				Duration timeElapsed = Duration.between(arrTime.toLocalTime(), depTime.toLocalTime());
				if (depTime.after(arrTime) && timeElapsed.toMinutes() > 120 && timeElapsed.toMinutes() < 480) {
					ConnectionOutput connectionOutput = new ConnectionOutput();
					connectionOutput.setConnArrAirport(arrFlight.getArrAirport());
					connectionOutput.setConnArrTime(arrFlight.getArrTime());
					connectionOutput.setConnDepAirport(arrFlight.getDepAirport());
					connectionOutput.setConnDepTime(arrFlight.getDepTime());
					connectionOutput.setConnFlightNo(arrFlight.getFlightNo());
					connectionOutput.setOnwardArrAirport(arrFlight.getArrAirport());
					connectionOutput.setOnwardArrTime(arrFlight.getArrTime());
					connectionOutput.setOnwardDepAirport(depFlight.getDepAirport());
					connectionOutput.setOnwardDepTime(depFlight.getDepTime());
					connectionOutput.setOnwardFlightNo(depFlight.getFlightNo());
					connectionResults.add(connectionOutput);
				}
			});
		});

		return connectionResults;
	}

}
