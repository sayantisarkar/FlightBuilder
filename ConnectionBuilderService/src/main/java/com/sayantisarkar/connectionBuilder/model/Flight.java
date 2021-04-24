package com.sayantisarkar.connectionBuilder.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name= "flight_no")
	private Integer flightNo;
	
	@Column(name= "dep_airport")
	private String depAirport;
	
	@Column(name = "arr_airport")
	private String arrAirport;
	
	@Column(name= "dep_time")
	private Time depTime;
	
	@Column(name= "arr_time")
	private Time arrTime;
	
	protected Flight() {}

	  public Flight(int flightNo, String depAirport,String arrAirport,Time depTime,Time arrTime) {
		  super();
	    this.flightNo = flightNo;
	    this.depAirport = depAirport;
	    this.arrAirport= arrAirport;
	    this.depTime= depTime;
	    this.arrTime= arrTime;
	  }
	
	public Integer getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(Integer flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public Time getDepTime() {
		return depTime;
	}
	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}
	public Time getArrTime() {
		return arrTime;
	}
	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}


}
