package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.Contact;
import com.springdatabase.basics.databasedemo.entity.Files;

@Repository
@Transactional
public class ContactService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Contact contact) {
		entityManager.merge(contact);
}

	public List<Contact> findAll() {
		TypedQuery<Contact> namedQuery = entityManager.createNamedQuery("find_all_contact",Contact.class);
		return namedQuery.getResultList();
		
	}
	
}
