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
@Table(name = "files")
@NamedQuery(name="find_all_files", query = "select f from Files f")
public class Files {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String size;
	private int downloads;
	
	@Column(name = "path_view")
	private String pathView;
	
	private String catalogy;
	
	@Column(name = "date_upload")
	private Date dateUpload;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getDownloads() {
		return downloads;
	}

	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public String getPathView() {
		return pathView;
	}

	public void setPathView(String pathView) {
		this.pathView = pathView;
	}

	public String getCatalogy() {
		return catalogy;
	}

	public void setCatalogy(String catalogy) {
		this.catalogy = catalogy;
	}

	
	public Date getDateUpload() {
		return dateUpload;
	}

	public void setDateUpload(Date dateUpload) {
		this.dateUpload = dateUpload;
	}

	public Files() {
		super();
	}

	public Files(String name, String size, int downloads, String pathView, String catalogy, Date dateUpload) {
		super();
		this.name = name;
		this.size = size;
		this.downloads = downloads;
		this.pathView = pathView;
		this.catalogy = catalogy;
		this.dateUpload = dateUpload;
	}

	public Files(int id, String name, String size, int downloads, String pathView, String catalogy, Date dateUpload) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.downloads = downloads;
		this.pathView = pathView;
		this.catalogy = catalogy;
		this.dateUpload = dateUpload;
	}
	
	
	 
}
