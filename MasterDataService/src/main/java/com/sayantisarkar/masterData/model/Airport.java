package com.sayantisarkar.masterData.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "airport_code")
	private String airportCode;

	@Column(name = "airport_name")
	private String airportName;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "coordinates")
	private String coordinates;

	protected Airport() {
	}

	public Airport(String airportCode, String airportName, String cityName, String coordinates) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.cityName = cityName;
		this.coordinates = coordinates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

}
