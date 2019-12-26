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
import com.springdatabase.basics.databasedemo.entity.SDTCO;

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

	public List<NhaDat> findAll_where_Top100_With_RegionName(String region) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+region+"' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaName(String tinhthanhpho, String quanhuyen) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+"' and f.areaName = '" +quanhuyen+"' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaNameCatalogyName(String tinhthanhpho, String quanhuyen,
			String chuyenmuc) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+"' and f.areaName = '" +quanhuyen+"' and f.catalogyName = '"+chuyenmuc+"' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeName(String tinhthanhpho,
			String quanhuyen, String chuyenmuc, String loai) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+"' and f.areaName = '" +quanhuyen+"' and f.catalogyName = '"+chuyenmuc+"' and f.typeName ='" +loai+ "' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_TuTimKiem(String tutimkiem) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.subjectLowerCase like '%" +tutimkiem+ "%' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNameTuTimKiem(String tinhthanhpho,
			String quanhuyen, String chuyenmuc, String loai, String tutimkiem) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+"' and f.areaName = '" +quanhuyen+"' and f.catalogyName = '"+chuyenmuc+"' and f.typeName ='" +loai+ "' and f.subjectLowerCase '%"+tutimkiem+ "%' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public void deletePost_haveSDT_inTable_SDTCO(List<SDTCO> listSDTCO) {
		for (SDTCO sdtco : listSDTCO) {
			TypedQuery namedQuery = entityManager.createQuery("Delete f from NhaDat f where f.phone = '" +sdtco.getPhone()+ "'", NhaDat.class);
			namedQuery.executeUpdate();
		}
		
	}

	


}
