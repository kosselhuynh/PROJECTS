package com.springdatabase.basics.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SDT_CO")
@NamedQuery(name="find_all_SDTCO", query = "select s from SDTCO s") //select nd from NhaDat nd
public class SDTCO {
	@Id
	private String  phone;
	
	@Column(name = "phan_tram")
	private int  phanTram;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPhanTram() {
		return phanTram;
	}

	public void setPhanTram(int phanTram) {
		this.phanTram = phanTram;
	}

	public SDTCO(String phone, int phanTram) {
		super();
		this.phone = phone;
		this.phanTram = phanTram;
	}

	public SDTCO() {
		super();
	}

	@Override
	public String toString() {
		return "SDTCO [phone=" + phone + ", phanTram=" + phanTram + "]";
	}

	
	
}
