package com.springdatabase.basics.databasedemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdParameters {

	private Ad ad;
	private List<Parameter> Parameters;
	private ad_params ad_params;
	
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	public List<Parameter> getParameters() {
		return Parameters;
	}
	public void setParameters(List<Parameter> parameters) {
		Parameters = parameters;
	}
	public ad_params getAd_params() {
		return ad_params;
	}
	public void setAd_params(ad_params ad_params) {
		this.ad_params = ad_params;
	}
	public AdParameters(Ad ad, List<Parameter> parameters,
			com.springdatabase.basics.databasedemo.entity.ad_params ad_params) {
		super();
		this.ad = ad;
		Parameters = parameters;
		this.ad_params = ad_params;
	}
	public AdParameters() {
		super();
	}
	@Override
	public String toString() {
		return "AdParamerters {[ad=" + ad + ", Parameters=" + Parameters + ", ad_params=" + ad_params + "}";
	}
	
	
}
