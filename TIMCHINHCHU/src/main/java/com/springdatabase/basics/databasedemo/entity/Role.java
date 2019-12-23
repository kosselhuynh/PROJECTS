package com.springdatabase.basics.databasedemo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
//@NamedQuery(name="find_all_files", query = "select f from Files f")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
    private int roleIid;

    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;

	public int getRoleIid() {
		return roleIid;
	}

	public void setRoleIid(int roleIid) {
		this.roleIid = roleIid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role() {
		super();
	}

	public Role(String name, List<User> users) {
		super();
		this.name = name;
		this.users = users;
	}

	public Role(int roleIid, String name, List<User> users) {
		super();
		this.roleIid = roleIid;
		this.name = name;
		this.users = users;
	}


}
