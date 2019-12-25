package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.NhaDatAll;
import com.springdatabase.basics.databasedemo.entity.SDTCO;
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

	public List<TanSuat> findAll_Where_more10Post() {
		List<TanSuat> result;
		TypedQuery<TanSuat> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select nd from TanSuat nd where nd.tanSuat >= 10", TanSuat.class);
			result = namedQuery.getResultList();
		}catch (NoResultException e) {
			return null;
		}
		return result;
	}

	public List<TanSuat> findAll_Where_listSDTCO_100Percent(List<SDTCO> listSDTCO_100Percent) {
		List<TanSuat> listResult = null;
		for (SDTCO sdtco : listSDTCO_100Percent) {
			List<TanSuat> results;
			TypedQuery<TanSuat> namedQuery;
			try {
				namedQuery = entityManager.createQuery("Select nd from TanSuat nd where nd.phone = '" + sdtco.getPhone()+ "'", TanSuat.class);
				results = namedQuery.getResultList();
				listResult.addAll(results);
			}catch (NoResultException e) {
				return null;
			}
		}
		return listResult;
	}

	public List<TanSuat> findAll_Where_TanSuat_Bigger_AVGTanSuat(double avgTanSuat) {
		List<TanSuat> result;
		TypedQuery<TanSuat> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select nd from TanSuat nd where nd.tanSuat >= " +avgTanSuat+ "'", TanSuat.class);
			result = namedQuery.getResultList();
		}catch (NoResultException e) {
			return null;
		}
		return result;
	}
}
