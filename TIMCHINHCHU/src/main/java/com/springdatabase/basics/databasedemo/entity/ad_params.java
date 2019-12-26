package com.springdatabase.basics.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ad_params {

	private Parameter address;
	private Parameter area;
	private Parameter landed_type;
	private Parameter direction;
	private Parameter property_legal_document;
	private Parameter property_road_condition;
	private Parameter region;
	private Parameter rooms;
	private Parameter size;
	private Parameter ward;
	
	
	public Parameter getDirection() {
		return direction;
	}
	public void setDirection(Parameter direction) {
		this.direction = direction;
	}
	public Parameter getProperty_legal_document() {
		return property_legal_document;
	}
	public void setProperty_legal_document(Parameter property_legal_document) {
		this.property_legal_document = property_legal_document;
	}
	public Parameter getProperty_road_condition() {
		return property_road_condition;
	}
	public void setProperty_road_condition(Parameter property_road_condition) {
		this.property_road_condition = property_road_condition;
	}
	public Parameter getAddress() {
		return address;
	}
	public void setAddress(Parameter address) {
		this.address = address;
	}
	public Parameter getArea() {
		return area;
	}
	public void setArea(Parameter area) {
		this.area = area;
	}
	public Parameter getLanded_type() {
		return landed_type;
	}
	public void setLanded_type(Parameter landed_type) {
		this.landed_type = landed_type;
	}
	public Parameter getRegion() {
		return region;
	}
	public void setRegion(Parameter region) {
		this.region = region;
	}
	public Parameter getRooms() {
		return rooms;
	}
	public void setRooms(Parameter rooms) {
		this.rooms = rooms;
	}
	public Parameter getSize() {
		return size;
	}
	public void setSize(Parameter size) {
		this.size = size;
	}
	public Parameter getWard() {
		return ward;
	}
	public void setWard(Parameter ward) {
		this.ward = ward;
	}
	public ad_params() {
		super();
	}
	public ad_params(Parameter address, Parameter area, Parameter landed_type, Parameter direction,
			Parameter property_legal_document, Parameter property_road_condition, Parameter region, Parameter rooms,
			Parameter size, Parameter ward) {
		super();
		this.address = address;
		this.area = area;
		this.landed_type = landed_type;
		this.direction = direction;
		this.property_legal_document = property_legal_document;
		this.property_road_condition = property_road_condition;
		this.region = region;
		this.rooms = rooms;
		this.size = size;
		this.ward = ward;
	}
	@Override
	public String toString() {
		return "ad_params [address=" + address + ", area=" + area + ", landed_type=" + landed_type + ", direction="
				+ direction + ", property_legal_document=" + property_legal_document + ", property_road_condition="
				+ property_road_condition + ", region=" + region + ", rooms=" + rooms + ", size=" + size + ", ward="
				+ ward + "]";
	}
	

	
	
	
	
}
