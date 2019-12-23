package com.springdatabase.basics.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "catalogy_tinhtp")
@NamedQuery(name="find_all_CatalogyTinhTP", query = "select t from CatalogyTinhTP t")
public class CatalogyTinhTP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "catalogy_name")
	private String catalogyName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatalogyName() {
		return catalogyName;
	}

	public void setCatalogyName(String catalogyName) {
		this.catalogyName = catalogyName;
	}

	public CatalogyTinhTP(int id, String catalogyName) {
		super();
		this.id = id;
		this.catalogyName = catalogyName;
	}

	public CatalogyTinhTP() {
		super();
	}

	@Override
	public String toString() {
		return "CatalogyTinhTP [id=" + id + ", catalogyName=" + catalogyName + "]";
	}
	
	
}
