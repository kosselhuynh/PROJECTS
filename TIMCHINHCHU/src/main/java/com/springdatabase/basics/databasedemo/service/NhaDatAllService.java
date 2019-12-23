package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.NhaDatAll;
import com.springdatabase.basics.databasedemo.entity.SDTCO;

@Repository
@Transactional
public class NhaDatAllService {

	@PersistenceContext
	EntityManager entityManager;

	// Get list
	public List<NhaDatAll> findAll() {
		TypedQuery<NhaDatAll> namedQuery = entityManager.createNamedQuery("find_all_NhaDatAll", NhaDatAll.class);
		return namedQuery.getResultList();
	}

	public boolean findOne_where_ListID(String ListID) {
		NhaDatAll rs = null;
		TypedQuery<NhaDatAll> namedQuery = null;
		try {
			namedQuery = entityManager.createQuery("Select nda from NhaDatAll nda where nda.listId = '"+ListID+"'", NhaDatAll.class);
			rs = namedQuery.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		if(rs == null) {
			return false;
		}else {
			return true;
		}
	}

	public void insert(NhaDatAll nhaDat) {
		entityManager.merge(nhaDat);		
	}
	
}
