package com.springdatabase.basics.databasedemo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.User;

@Repository
@Transactional
public class RegisterService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager entityManager;
	
	public User insert(User user) {
		return entityManager.merge(user);
	}

}
