package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.NhaDatAll;
import com.springdatabase.basics.databasedemo.entity.TanSuat;

@Repository
@Transactional
public class TanSuatService {

	@PersistenceContext
	EntityManager entityManager;

	// Get list
	public List<TanSuat> findAll() {
		TypedQuery<TanSuat> namedQuery = entityManager.createNamedQuery("find_all_TanSuat", TanSuat.class);
		return namedQuery.getResultList();
	}
	
	public void insert(TanSuat tanSuat) {
		entityManager.merge(tanSuat);		
	}
	
	public boolean findOne_where_ListID(String listID) {
		TanSuat rs = null;
		TypedQuery<TanSuat> namedQuery = null;
		try {
			namedQuery = entityManager.createQuery("Select ts from TanSuat ts where ts.listId = '"+listID+"'", TanSuat.class);
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

	public boolean findOne_where_Phone(String phone) {
		TanSuat rs = null;
		TypedQuery<TanSuat> namedQuery = null;
		try {
			namedQuery = entityManager.createQuery("Select ts from TanSuat ts where ts.phone = '"+phone+"'", TanSuat.class);
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

	public TanSuat getOne_where_Phone(String phone) {
		TanSuat rs = null;
		TypedQuery<TanSuat> namedQuery = null;
		try {
			namedQuery = entityManager.createQuery("Select ts from TanSuat ts where ts.phone = '"+phone+"'", TanSuat.class);
			rs = namedQuery.getSingleResult();
		} catch (NoResultException e) {
			return rs;
		}
		if(rs == null) {
			return rs;
		}else {
			return rs;
		}
	}
}
