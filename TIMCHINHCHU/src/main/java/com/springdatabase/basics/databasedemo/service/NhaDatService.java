package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
	
//	public int findSDT_DangBai(String sdt) {
//		List  l;
//		try {
//			l = entityManager.createQuery("Select count(nd.id) from NhaDat nd where nd.phone = '"+sdt+"'").getResultList();
//		}catch (NoResultException e) {
//			return 0;
//		}
//		return l.size();
//	}
}
