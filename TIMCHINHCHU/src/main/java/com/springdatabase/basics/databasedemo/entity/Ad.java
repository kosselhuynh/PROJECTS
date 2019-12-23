package com.springdatabase.basics.databasedemo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ad {

		private String ad_id;
		private String list_id;
		private String list_time;
		private String date;
		private String account_id;
		private String account_oid;
		private String account_name;
		private String subject;
		private String body;
		private int area;
		private String area_name;
		private int region;
		private String region_name;
		private int category;
        private String category_name;
        private boolean company_ad;
        private String phone;
        private String type;
        private String type_name;
        private String price;
        private String price_string;
        private String reviewer_image;
        private String reviewer_nickname;
        private List<Images> images;
        private String thumbnail_image;
        private String address;
        private String rooms;
        private int  size;
        private int  toilets;
        private boolean owner;
        private String avatar;
        private int floors;
        private int landed_type;
        private int property_legal_document;
        private int property_road_condition;
        private int region_v2;
        private int area_v2;
        private int ward;
        private String ward_name;
        private int street_id;
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
		public int getCategory() {
			return category;
		}
		public void setCategory(int category) {
			this.category = category;
		}
		public String getCategory_name() {
			return category_name;
		}
		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}
		public boolean isCompany_ad() {
			return company_ad;
		}
		public void setCompany_ad(boolean company_ad) {
			this.company_ad = company_ad;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getType_name() {
			return type_name;
		}
		public void setType_name(String type_name) {
			this.type_name = type_name;
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
		public String getReviewer_image() {
			return reviewer_image;
		}
		public void setReviewer_image(String reviewer_image) {
			this.reviewer_image = reviewer_image;
		}
		public String getReviewer_nickname() {
			return reviewer_nickname;
		}
		public void setReviewer_nickname(String reviewer_nickname) {
			this.reviewer_nickname = reviewer_nickname;
		}
		public List<Images> getImages() {
			return images;
		}
		public void setImages(List<Images> images) {
			this.images = images;
		}
		public String getThumbnail_image() {
			return thumbnail_image;
		}
		public void setThumbnail_image(String thumbnail_image) {
			this.thumbnail_image = thumbnail_image;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRooms() {
			return rooms;
		}
		public void setRooms(String rooms) {
			this.rooms = rooms;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getToilets() {
			return toilets;
		}
		public void setToilets(int toilets) {
			this.toilets = toilets;
		}
		public boolean isOwner() {
			return owner;
		}
		public void setOwner(boolean owner) {
			this.owner = owner;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public int getFloors() {
			return floors;
		}
		public void setFloors(int floors) {
			this.floors = floors;
		}
		public int getLanded_type() {
			return landed_type;
		}
		public void setLanded_type(int landed_type) {
			this.landed_type = landed_type;
		}
		public int getProperty_legal_document() {
			return property_legal_document;
		}
		public void setProperty_legal_document(int property_legal_document) {
			this.property_legal_document = property_legal_document;
		}
		public int getProperty_road_condition() {
			return property_road_condition;
		}
		public void setProperty_road_condition(int property_road_condition) {
			this.property_road_condition = property_road_condition;
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
		public int getStreet_id() {
			return street_id;
		}
		public void setStreet_id(int street_id) {
			this.street_id = street_id;
		}
		public Ad(String ad_id, String list_id, String list_time, String date, String account_id, String account_oid,
				String account_name, String subject, String body, int area, String area_name, int region,
				String region_name, int category, String category_name, boolean company_ad, String phone, String type,
				String type_name, String price, String price_string, String reviewer_image, String reviewer_nickname,
				List<Images> images, String thumbnail_image, String address, String rooms, int size, int toilets,
				boolean owner, String avatar, int floors, int landed_type, int property_legal_document,
				int property_road_condition, int region_v2, int area_v2, int ward, String ward_name, int street_id) {
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
			this.area = area;
			this.area_name = area_name;
			this.region = region;
			this.region_name = region_name;
			this.category = category;
			this.category_name = category_name;
			this.company_ad = company_ad;
			this.phone = phone;
			this.type = type;
			this.type_name = type_name;
			this.price = price;
			this.price_string = price_string;
			this.reviewer_image = reviewer_image;
			this.reviewer_nickname = reviewer_nickname;
			this.images = images;
			this.thumbnail_image = thumbnail_image;
			this.address = address;
			this.rooms = rooms;
			this.size = size;
			this.toilets = toilets;
			this.owner = owner;
			this.avatar = avatar;
			this.floors = floors;
			this.landed_type = landed_type;
			this.property_legal_document = property_legal_document;
			this.property_road_condition = property_road_condition;
			this.region_v2 = region_v2;
			this.area_v2 = area_v2;
			this.ward = ward;
			this.ward_name = ward_name;
			this.street_id = street_id;
		}
		public Ad() {
			super();
		}
		@Override
		public String toString() {
			return "Ad {ad_id=" + ad_id + ", list_id=" + list_id + ", list_time=" + list_time + ", date=" + date
					+ ", account_id=" + account_id + ", account_oid=" + account_oid + ", account_name=" + account_name
					+ ", subject=" + subject + ", body=" + body + ", area=" + area + ", area_name=" + area_name
					+ ", region=" + region + ", region_name=" + region_name + ", category=" + category
					+ ", category_name=" + category_name + ", company_ad=" + company_ad + ", phone=" + phone + ", type="
					+ type + ", type_name=" + type_name + ", price=" + price + ", price_string=" + price_string
					+ ", reviewer_image=" + reviewer_image + ", reviewer_nickname=" + reviewer_nickname + ", images="
					+ images + ", thumbnail_image=" + thumbnail_image + ", address=" + address + ", rooms=" + rooms
					+ ", size=" + size + ", toilets=" + toilets + ", owner=" + owner + ", avatar=" + avatar
					+ ", floors=" + floors + ", landed_type=" + landed_type + ", property_legal_document="
					+ property_legal_document + ", property_road_condition=" + property_road_condition + ", region_v2="
					+ region_v2 + ", area_v2=" + area_v2 + ", ward=" + ward + ", ward_name=" + ward_name
					+ ", street_id=" + street_id + "}";
		}
 
 
        
}
