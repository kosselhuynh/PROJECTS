package com.springdatabase.basics.databasedemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "trending")
@NamedQuery(name="find_all_trending", query = "select t from Trending t")
public class Trending {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name_search")
	private String nameSearch;

	@Column(name = "number_search")
	private int numberSearch;

	@Column(name = "date_search")
	private Date dateSearch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public int getNumberSearch() {
		return numberSearch;
	}

	public void setNumberSearch(int numberSearch) {
		this.numberSearch = numberSearch;
	}

	public Date getDateSearch() {
		return dateSearch;
	}

	public void setDateSearch(Date dateSearch) {
		this.dateSearch = dateSearch;
	}

	public Trending() {
		super();
	}

	public Trending(String nameSearch, int numberSearch, Date dateSearch) {
		super();
		this.nameSearch = nameSearch;
		this.numberSearch = numberSearch;
		this.dateSearch = dateSearch;
	}

	public Trending(int id, String nameSearch, int numberSearch, Date dateSearch) {
		super();
		this.id = id;
		this.nameSearch = nameSearch;
		this.numberSearch = numberSearch;
		this.dateSearch = dateSearch;
	}
	
	

}
