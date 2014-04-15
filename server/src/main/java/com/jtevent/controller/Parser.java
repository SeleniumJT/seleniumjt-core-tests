package com.jtevent.controller;

import org.apache.commons.lang3.StringUtils;

public class Parser {
	
	boolean table;
	boolean buses;
	boolean busstops;
	StringBuilder sb = new StringBuilder();
	
	public void add(String s) {
		if(buses) sb.append(s.replace("182/", ""));
		else sb.append(s);
	}
	
	public void setParsingSelect(String s) {
		if ( StringUtils.contains(s, "routeId")) {
			buses = true;
		}
		else if ( StringUtils.contains(s, "stopId")) {
			busstops = true;
		}
	}
	
	public boolean parsingSelect() {
		return buses || busstops;
	}
	
	public void reset() {
		table = false;
		buses = false;
		busstops = false;
		sb = new StringBuilder();
	}
	
	public String get() {
		return sb.toString();
	}
	
	public boolean parsingTable() {
		return table;
	}
	
	public boolean parsingBuses() {
		return buses;
	}
	
	public boolean parsingBusStops() {
		return busstops;
	}
	
	public void setParsingTable() {
		table = true;
		buses = false;
		busstops = false;
	}
	
	public void parseBuses() {
		table = false;
		buses = true;
		busstops = false;
	}
	
	public void parseBusStops() {
		table = false;
		buses = false;
		busstops = true;
	}
}
