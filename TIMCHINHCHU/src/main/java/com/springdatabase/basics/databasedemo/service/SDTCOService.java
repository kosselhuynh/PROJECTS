package com.springdatabase.basics.databasedemo.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.SDTCO;

@Repository
@Transactional
public class SDTCOService {

	@PersistenceContext
	EntityManager entityManager;


	// Get list
	public List<SDTCO> findAll() {
		TypedQuery<SDTCO> namedQuery = entityManager.createNamedQuery("find_all_SDTCO", SDTCO.class);
		return namedQuery.getResultList();
	}
	
	public void insert(SDTCO sdtCo) {
		entityManager.merge(sdtCo);

	}
	//insert list
	public void insert(List<SDTCO> sdtCo) {
		for (SDTCO sdtco2 : sdtCo) {
			entityManager.merge(sdtco2);
		}
		

	}

	public boolean findOneWithPhone(String phone) {
		SDTCO rs = null;
		TypedQuery<SDTCO> namedQuery = null;
		try {
			namedQuery = entityManager.createQuery("Select s from SDTCO s where s.phone = '" + phone + "'",
					SDTCO.class);
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

	
}
