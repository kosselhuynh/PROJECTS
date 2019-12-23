package com.springdatabase.basics.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {

	private String image;

	public Images(String image) {
		super();
		this.image = image;
	}

	public Images() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Images [image=" + image + "]";
	}
	
	
	
}
