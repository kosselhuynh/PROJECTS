package com.springdatabase.basics.databasedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"list_id"})
public class Ads {

	private String ad_id;
	private String list_id;
	private String list_time;
	private String date;
	private String account_id;
	
	private String account_oid;
	private String account_name;
	private String subject;
	private String body;
	private int category;
	
	private int area;
	private String area_name;
	private int region;
	private String region_name;
	private boolean company_ad;
	
	private String type;
	private String price;
	private String price_string;
	private String image;
	private int number_of_images;
	
	private String avatar;
	private int rooms;
	private int apartment_type;
	private int property_status;
	private int landed_type;
	
	private int region_v2;
	private int area_v2;
	private int ward;
	private String ward_name;
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getList_id() {
		return list_id;
	}
	public void setList_id(String list_id) {
		this.list_id = list_id;
	}
	public String getList_time() {
		return list_time;
	}
	public void setList_time(String list_time) {
		this.list_time = list_time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_oid() {
		return account_oid;
	}
	public void setAccount_oid(String account_oid) {
		this.account_oid = account_oid;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public boolean getCompany_ad() {
		return company_ad;
	}
	public void setCompany_ad(boolean company_ad) {
		this.company_ad = company_ad;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice_string() {
		return price_string;
	}
	public void setPrice_string(String price_string) {
		this.price_string = price_string;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNumber_of_images() {
		return number_of_images;
	}
	public void setNumber_of_images(int number_of_images) {
		this.number_of_images = number_of_images;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getApartment_type() {
		return apartment_type;
	}
	public void setApartment_type(int apartment_type) {
		this.apartment_type = apartment_type;
	}
	public int getProperty_status() {
		return property_status;
	}
	public void setProperty_status(int property_status) {
		this.property_status = property_status;
	}
	public int getLanded_type() {
		return landed_type;
	}
	public void setLanded_type(int landed_type) {
		this.landed_type = landed_type;
	}
	public int getRegion_v2() {
		return region_v2;
	}
	public void setRegion_v2(int region_v2) {
		this.region_v2 = region_v2;
	}
	public int getArea_v2() {
		return area_v2;
	}
	public void setArea_v2(int area_v2) {
		this.area_v2 = area_v2;
	}
	public int getWard() {
		return ward;
	}
	public void setWard(int ward) {
		this.ward = ward;
	}
	public String getWard_name() {
		return ward_name;
	}
	public void setWard_name(String ward_name) {
		this.ward_name = ward_name;
	}
	public Ads(String ad_id, String list_id, String list_time, String date, String account_id, String account_oid,
			String account_name, String subject, String body, int category, int area, String area_name, int region,
			String region_name, boolean company_ad, String type, String price, String price_string, String image,
			int number_of_images, String avatar, int rooms, int apartment_type, int property_status, int landed_type,
			int region_v2, int area_v2, int ward, String ward_name) {
		super();
		this.ad_id = ad_id;
		this.list_id = list_id;
		this.list_time = list_time;
		this.date = date;
		this.account_id = account_id;
		this.account_oid = account_oid;
		this.account_name = account_name;
		this.subject = subject;
		this.body = body;
		this.category = category;
		this.area = area;
		this.area_name = area_name;
		this.region = region;
		this.region_name = region_name;
		this.company_ad = company_ad;
		this.type = type;
		this.price = price;
		this.price_string = price_string;
		this.image = image;
		this.number_of_images = number_of_images;
		this.avatar = avatar;
		this.rooms = rooms;
		this.apartment_type = apartment_type;
		this.property_status = property_status;
		this.landed_type = landed_type;
		this.region_v2 = region_v2;
		this.area_v2 = area_v2;
		this.ward = ward;
		this.ward_name = ward_name;
	}
	public Ads() {
		super();
	}
	@Override
	public String toString() {
		return "Ads [ad_id=" + ad_id + ", list_id=" + list_id + ", list_time=" + list_time + ", date=" + date
				+ ", account_id=" + account_id + ", account_oid=" + account_oid + ", account_name=" + account_name
				+ ", subject=" + subject + ", body=" + body + ", category=" + category + ", area=" + area
				+ ", area_name=" + area_name + ", region=" + region + ", region_name=" + region_name + ", company_ad="
				+ company_ad + ", type=" + type + ", price=" + price + ", price_string=" + price_string + ", image="
				+ image + ", number_of_images=" + number_of_images + ", avatar=" + avatar + ", rooms=" + rooms
				+ ", apartment_type=" + apartment_type + ", property_status=" + property_status + ", landed_type="
				+ landed_type + ", region_v2=" + region_v2 + ", area_v2=" + area_v2 + ", ward=" + ward + ", ward_name="
				+ ward_name + "]";
	}
	
	
	
	
}
