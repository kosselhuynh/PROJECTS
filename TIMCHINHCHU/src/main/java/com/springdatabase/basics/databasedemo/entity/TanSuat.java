package com.springdatabase.basics.databasedemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TanSuat")
@NamedQuery(name="find_all_TanSuat", query = "select ts from TanSuat ts")
public class TanSuat {

	@Id
	private String  phone;
	
	@Column(name = "so_lan_dang_bai")
	private int  soLanDangBai;
	
	@Column(name = "so_ngay")
	private int  soNgay;
	
	@Column(name = "first_date")
	private String  firstDate;
	
	@Column(name = "last_date")
	private String  lastDate;
	
	@Column(name = "tan_suat")
	private double  tanSuat;//tanSuat = soLanDangBai/soNgay

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public int getSoLanDangBai() {
		return soLanDangBai;
	}

	public void setSoLanDangBai(int soLanDangBai) {
		this.soLanDangBai = soLanDangBai;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public double getTanSuat() {
		return tanSuat;
	}

	public void setTanSuat(double tanSuat) {
		this.tanSuat = tanSuat;
	}

	
	public TanSuat() {
		super();
	}

	public TanSuat(String phone, int soLanDangBai, int soNgay, String firstDate, String lastDate, double tanSuat) {
		super();
		this.phone = phone;
		this.soLanDangBai = soLanDangBai;
		this.soNgay = soNgay;
		this.firstDate = firstDate;
		this.lastDate = lastDate;
		this.tanSuat = tanSuat;
	}

	@Override
	public String toString() {
		return "TanSuat [phone=" + phone + ", soLanDangBai=" + soLanDangBai + ", soNgay=" + soNgay + ", firstDate="
				+ firstDate + ", lastDate=" + lastDate + ", tanSuat=" + tanSuat + "]";
	}

	
	
	

	
	
	
}
