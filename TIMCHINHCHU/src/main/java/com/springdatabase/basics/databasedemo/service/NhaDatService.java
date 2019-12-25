package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.NhaDat;

@Repository
@Transactional
public class NhaDatService {

	@PersistenceContext
	EntityManager entityManager;

	// Get list
	public List<NhaDat> findAll() {
		TypedQuery<NhaDat> namedQuery = entityManager.createNamedQuery("find_all_NhaDat", NhaDat.class);
		return namedQuery.getResultList();
	}

	public void insert(List<NhaDat> listNhaDat) {
		for (NhaDat nhaDat : listNhaDat) {
			entityManager.merge(nhaDat);
		}

	}

	public void insert(NhaDat nhaDat) {
		entityManager.merge(nhaDat);
	}
	
	public NhaDat findOne_where_ListID(String ListID) {
		NhaDat result;
		TypedQuery<NhaDat> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select nd from NhaDat nd where nd.listId = '"+ListID+"'", NhaDat.class);
			result = namedQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return result;
	}

	public List<NhaDat> findAll_With_RegionName(String region) {
		List<NhaDat> result;
		TypedQuery<NhaDat> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select nd from NhaDat nd where nd.regionName = '"+region+"'", NhaDat.class);
			result = namedQuery.getResultList();
		}catch (NoResultException e) {
			return null;
		}
		return result;
	}
	
	public List<NhaDat> findAll_where_Top100() {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}
}
