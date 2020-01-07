package com.springdatabase.basics.databasedemo.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.User;

@Repository
@Transactional
public class UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	EntityManager entityManager;

	public boolean findAll_where_emailAndpassword(String email, String password) {
		User user = new User();
		TypedQuery<User> namedQuery = entityManager.createQuery("Select u from User u where u.email  ='" + email + "' and u.password='"+password+"'", User.class);
		try {
			user = namedQuery.getSingleResult();
		}catch(Exception ex) {
			return false;
		}
		
		if(!StringUtils.isEmpty(user.getFullname())) {
			return true;
		}else {
			return false;
		}
	}

	public boolean findByEmail(String email) {
		User user = new User();
		TypedQuery<User> namedQuery = entityManager.createQuery("Select u from User u where u.email  ='" + email + "'", User.class);
		try {
			user = namedQuery.getSingleResult();
		}catch(Exception ex) {
			return false;
		}
		
		if(!StringUtils.isEmpty(user.getFullname())) {
			return true;
		}else {
			return false;
		}
	}
	
	public void updateUser(User user) {
		entityManager.merge(user);
	}
}
