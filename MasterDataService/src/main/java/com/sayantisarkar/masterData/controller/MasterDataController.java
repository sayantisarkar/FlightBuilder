package com.sayantisarkar.masterData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayantisarkar.masterData.model.Airport;
import com.sayantisarkar.masterData.service.MasterDataService;

@CrossOrigin
@RestController
public class MasterDataController {

	@Autowired
	private MasterDataService masterDataService;

	@GetMapping("/master-data")
	private ResponseEntity<List<Airport>> getAirportsMasterData() {
		try {
			List<Airport> masterData = masterDataService.getAirportsMasterData();
			if (masterData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(masterData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/master-data")
	public ResponseEntity<Airport> createAirportData(@RequestBody Airport masterData) {
		try {
			Airport addedMasterData = masterDataService.createAirportData(masterData);
			return new ResponseEntity<>(addedMasterData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/master-data/{id}")
	public ResponseEntity<Airport> updateAirportData(@PathVariable("id") long airportId,
			@RequestBody Airport masterData) {
		try {
			Airport updatedAirportData = masterDataService.updateAirportData(airportId, masterData);
			if (updatedAirportData == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(updatedAirportData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/master-data/{id}")
	public ResponseEntity<HttpStatus> deleteAirportData(@PathVariable("id") long id) {
		try {
			masterDataService.deleteAirportData(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/master-data")
	public ResponseEntity<HttpStatus> deleteAllAirportData() {
		try {
			masterDataService.deleteAllAirportData();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
