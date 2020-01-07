package com.springdatabase.basics.databasedemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
//@NamedQuery(name="find_all_files", query = "select f from Files f")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private int UserId;

	@NotNull(message = "Name cannot be null from 2-30 character")
    @Size(min = 2, max = 30)
    private String fullname;

	@Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "is required")
    @Min(5)
    private String password;
    
    @Column(name = "confirm_password")
    @Min(5)
    @NotNull(message = "is required")
    private String confirmPassword;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

   	private String nhadats;
	
   	
	public String getNhadats() {
		return nhadats;
	}

	public void setNhadats(String nhadats) {
		this.nhadats = nhadats;
	}

	public String getFullname() {
		return fullname;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
	}
    
	public User(String fullname, String email, String password, String confirmPassword, Role role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}
	public User(int userId, String fullname, String email, String password, String confirmPassword, Role role) {
		super();
		this.UserId = userId;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}

}