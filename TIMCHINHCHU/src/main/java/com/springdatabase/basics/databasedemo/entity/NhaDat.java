package com.springdatabase.basics.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "NHA_DAT")
@NamedQuery(name="find_all_NhaDat", query = "select nd from NhaDat nd")
public class NhaDat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "list_id")
	private String listId;
	  
	private boolean owner;
	
	private String  subject;
	
	@Column(name = "date_upload")
	private String  dateUpload;
	
	@Column(name = "list_time")
	private String listTime;
	
	@Column(name = "account_name")
	private String  accountName;
	
	@Lob
	private String body;
	  
	private String  address;
	
	@Column(name = "ward_name")
	private String  wardName;
	
	@Column(name = "area_name")
	private String  areaName;
	
	private int region;
	@Column(name = "region_name")
	private String  regionName;
	  
	private String  price;
	
	@Column(name = "price_string")
	private String  priceString;
	
	private int  rooms;
	
	@Column(name = "category_name")
	private String  categoryname;
	
	private String  phone;
	
	@Column(name = "type_name")
	private String  typeName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDateUpload() {
		return dateUpload;
	}

	public void setDateUpload(String dateUpload) {
		this.dateUpload = dateUpload;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPriceString() {
		return priceString;
	}

	public void setPriceString(String priceString) {
		this.priceString = priceString;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	
	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	

	public NhaDat() {
		super();
	}

	
	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}
	
	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}
	
	

	public String getListTime() {
		return listTime;
	}

	public void setListTime(String listTime) {
		this.listTime = listTime;
	}

	public NhaDat(int id, String listId, boolean owner, String subject, String dateUpload, String accountName,
			String body, String address, String wardName, String areaName, int region, String regionName, String price,
			String priceString, int rooms, String categoryname, String phone, String typeName, String listTime) {
		super();
		this.id = id;
		this.listId = listId;
		this.owner = owner;
		this.subject = subject;
		this.dateUpload = dateUpload;
		this.accountName = accountName;
		this.body = body;
		this.address = address;
		this.wardName = wardName;
		this.areaName = areaName;
		this.region = region;
		this.regionName = regionName;
		this.price = price;
		this.priceString = priceString;
		this.rooms = rooms;
		this.categoryname = categoryname;
		this.phone = phone;
		this.typeName = typeName;
		this.listTime = listTime;
	}

	@Override
	public String toString() {
		return "NhaDat [id=" + id + ", listId=" + listId + ", owner=" + owner + ", subject=" + subject + ", dateUpload="
				+ dateUpload + ", accountName=" + accountName + ", body=" + body + ", address=" + address
				+ ", wardName=" + wardName + ", areaName=" + areaName + ", regionName=" + regionName + ", price="
				+ price + ", priceString=" + priceString + ", rooms=" + rooms + ", categoryname=" + categoryname
				+ ", phone=" + phone + ", typeName=" + typeName  + "]";
	}

	
	
	
}
