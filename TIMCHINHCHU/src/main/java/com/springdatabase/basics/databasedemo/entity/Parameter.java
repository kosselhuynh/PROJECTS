package com.springdatabase.basics.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameter {

	private String id;
	private String value;
	private String label;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Parameter(String id, String value, String label) {
		super();
		this.id = id;
		this.value = value;
		this.label = label;
	}
	public Parameter() {
		super();
	}
	@Override
	public String toString() {
		return "Parameter {id=" + id + ", value=" + value + ", label=" + label + "}";
	}
	
	
}
