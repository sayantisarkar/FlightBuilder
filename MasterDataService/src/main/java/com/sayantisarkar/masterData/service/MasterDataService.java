package com.sayantisarkar.masterData.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayantisarkar.masterData.model.Airport;
import com.sayantisarkar.masterData.repository.MasterDataRepository;

@Service
public class MasterDataService {

//	@Autowired
//	private JdbcTemplate template;

	@Autowired
	private MasterDataRepository masterRepository;

	public List<Airport> getAirportsMasterData() {

		// String sql = "SELECT * FROM AIRPORTSMASTERDATA";
		// return template.query(sql, new BeanPropertyRowMapper<>(Airport.class));

		List<Airport> masterData = new ArrayList<>();
		masterRepository.findAll().forEach(masterData::add);
		return masterData;

	}

	public Airport createAirportData(Airport masterData) {
		Airport addedMasterData = masterRepository.save(new Airport(masterData.getAirportCode(),
				masterData.getAirportName(), masterData.getCityName(), masterData.getCoordinates()));
		return addedMasterData;
	}

	public Airport updateAirportData(long airportId, Airport masterData) {
		Optional<Airport> existingMasterData = masterRepository.findById(airportId);
		Airport updatedAirportData = null;
		if (existingMasterData.isPresent()) {
			existingMasterData.get().setAirportCode(masterData.getAirportCode());
			existingMasterData.get().setAirportName(masterData.getAirportName());
			existingMasterData.get().setCityName(masterData.getCityName());
			existingMasterData.get().setCoordinates(masterData.getCoordinates());
			updatedAirportData = masterRepository.save(existingMasterData.get());
			return updatedAirportData;
		}
		return updatedAirportData;
	}

	public void deleteAirportData(long id) {
		masterRepository.deleteById(id);
	}

	public void deleteAllAirportData() {
		masterRepository.deleteAll();
	}

}
