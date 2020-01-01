package com.springdatabase.basics.databasedemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "subject_lowercase")
	private String subjectLowerCase;
	
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
	
	@Column(name = "catalogy_name")
	private String  catalogyName;
	
	private String  phone;
	
	@Column(name = "type_name")
	private String  typeName;
	
	//Dung sort khi get tu db len
	@Column(name = "date_upload_convert")
	private Date  dateUploadConvert;
	
	private String direction;
	
	@Column(name = "property_legal_document")
	private String propertyLegalDocument;
	
	@Column(name = "property_road_condition")
	private String propertyRoadCondition;
	
	private int sobaidang;
	
	private int songay;
		
	
	

	public int getSobaidang() {
		return sobaidang;
	}

	public void setSobaidang(int sobaidang) {
		this.sobaidang = sobaidang;
	}

	public int getSongay() {
		return songay;
	}

	public void setSongay(int songay) {
		this.songay = songay;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPropertyLegalDocument() {
		return propertyLegalDocument;
	}

	public void setPropertyLegalDocument(String propertyLegalDocument) {
		this.propertyLegalDocument = propertyLegalDocument;
	}

	public String getPropertyRoadCondition() {
		return propertyRoadCondition;
	}

	public void setPropertyRoadCondition(String propertyRoadCondition) {
		this.propertyRoadCondition = propertyRoadCondition;
	}

	public Date getDateUploadConvert() {
		return dateUploadConvert;
	}

	public void setDateUploadConvert(Date dateUploadConvert) {
		this.dateUploadConvert = dateUploadConvert;
	}

	
	public String getSubjectLowerCase() {
		return subjectLowerCase;
	}

	public void setSubjectLowerCase(String subjectLowerCase) {
		this.subjectLowerCase = subjectLowerCase;
	}

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

	

	public String getCatalogyName() {
		return catalogyName;
	}

	public void setCatalogyName(String catalogyName) {
		this.catalogyName = catalogyName;
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

	public NhaDat(int id, String listId, boolean owner, String subject, String subjectLowerCase, String dateUpload,
			String listTime, String accountName, String body, String address, String wardName, String areaName,
			int region, String regionName, String price, String priceString, int rooms, String catalogyName,
			String phone, String typeName, Date dateUploadConvert, String direction, String propertyLegalDocument,
			String propertyRoadCondition) {
		super();
		this.id = id;
		this.listId = listId;
		this.owner = owner;
		this.subject = subject;
		this.subjectLowerCase = subjectLowerCase;
		this.dateUpload = dateUpload;
		this.listTime = listTime;
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
		this.catalogyName = catalogyName;
		this.phone = phone;
		this.typeName = typeName;
		this.dateUploadConvert = dateUploadConvert;
		this.direction = direction;
		this.propertyLegalDocument = propertyLegalDocument;
		this.propertyRoadCondition = propertyRoadCondition;
	}

	@Override
	public String toString() {
		return "NhaDat [id=" + id + ", listId=" + listId + ", owner=" + owner + ", subject=" + subject
				+ ", subjectLowerCase=" + subjectLowerCase + ", dateUpload=" + dateUpload + ", listTime=" + listTime
				+ ", accountName=" + accountName + ", body=" + body + ", address=" + address + ", wardName=" + wardName
				+ ", areaName=" + areaName + ", region=" + region + ", regionName=" + regionName + ", price=" + price
				+ ", priceString=" + priceString + ", rooms=" + rooms + ", catalogyName=" + catalogyName + ", phone="
				+ phone + ", typeName=" + typeName + ", dateUploadConvert=" + dateUploadConvert + ", direction="
				+ direction + ", propertyLegalDocument=" + propertyLegalDocument + ", propertyRoadCondition="
				+ propertyRoadCondition + "]";
	}

	
	
}
