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
@Table(name = "contact")
@NamedQuery(name="find_all_contact", query = "select c from Contact c")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String fullname;
	
	private String email;

	private String subject;

	private String message;

	@Column(name = "date_send")
	private Date dateSend;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateSend() {
		return dateSend;
	}

	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}

	public Contact() {
		super();
	}

	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Contact(String fullname, String email, String subject, String message, Date dateSend) {
		super();
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.dateSend = dateSend;
		this.fullname = fullname;
	}

	public Contact(int id, String fullname, String email, String subject, String message, Date dateSend) {
		super();
		this.id = id;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.dateSend = dateSend;
		this.fullname = fullname;
	}
	
	
}
