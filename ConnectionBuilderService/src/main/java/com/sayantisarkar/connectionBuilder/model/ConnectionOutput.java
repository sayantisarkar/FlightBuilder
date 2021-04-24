package com.sayantisarkar.connectionBuilder.model;

import java.sql.Time;

public class ConnectionOutput {

	private Integer onwardFlightNo;

	private String onwardDepAirport;

	private String onwardArrAirport;

	private Time onwardDepTime;

	private Time onwardArrTime;

	private Integer connFlightNo;

	private String connDepAirport;

	private String connArrAirport;

	private Time connDepTime;

	private Time connArrTime;

	public Integer getOnwardFlightNo() {
		return onwardFlightNo;
	}

	public void setOnwardFlightNo(Integer onwardFlightNo) {
		this.onwardFlightNo = onwardFlightNo;
	}

	public String getOnwardDepAirport() {
		return onwardDepAirport;
	}

	public void setOnwardDepAirport(String onwardDepAirport) {
		this.onwardDepAirport = onwardDepAirport;
	}

	public String getOnwardArrAirport() {
		return onwardArrAirport;
	}

	public void setOnwardArrAirport(String onwardArrAirport) {
		this.onwardArrAirport = onwardArrAirport;
	}

	public Time getOnwardDepTime() {
		return onwardDepTime;
	}

	public void setOnwardDepTime(Time onwardDepTime) {
		this.onwardDepTime = onwardDepTime;
	}

	public Time getOnwardArrTime() {
		return onwardArrTime;
	}

	public void setOnwardArrTime(Time onwardArrTime) {
		this.onwardArrTime = onwardArrTime;
	}

	public Integer getConnFlightNo() {
		return connFlightNo;
	}

	public void setConnFlightNo(Integer connFlightNo) {
		this.connFlightNo = connFlightNo;
	}

	public String getConnDepAirport() {
		return connDepAirport;
	}

	public void setConnDepAirport(String connDepAirport) {
		this.connDepAirport = connDepAirport;
	}

	public String getConnArrAirport() {
		return connArrAirport;
	}

	public void setConnArrAirport(String connArrAirport) {
		this.connArrAirport = connArrAirport;
	}

	public Time getConnDepTime() {
		return connDepTime;
	}

	public void setConnDepTime(Time connDepTime) {
		this.connDepTime = connDepTime;
	}

	public Time getConnArrTime() {
		return connArrTime;
	}

	public void setConnArrTime(Time connArrTime) {
		this.connArrTime = connArrTime;
	}

}
