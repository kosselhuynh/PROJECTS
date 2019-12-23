package com.springdatabase.basics.databasedemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoTot {
	private int total;
	private List<Ads> ads;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Ads> getAds() {
		return ads;
	}
	public void setAds(List<Ads> ads) {
		this.ads = ads;
	}
	public ChoTot(int total, List<Ads> ads) {
		super();
		this.total = total;
		this.ads = ads;
	}
	public ChoTot() {
		super();
	}
	@Override
	public String toString() {
		return "ChoTot {total=" + total + ", ads=" + ads + "}";
	}
	
	
	
	
}
