package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.SDTCO;

@Repository
@Transactional
public class NhaDatService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.subjectLowerCase like '%" 
				+tutimkiem+ "%' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNameTuTimKiem(String tinhthanhpho,
			String quanhuyen, String cata, String type, String tutimkiem) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+"' and f.areaName = '" +quanhuyen+"' and f.catalogyName = '"+cata+"' and f.typeName ='" +type+ "' and f.subjectLowerCase '%"+tutimkiem+ "%' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public void deletePost_haveSDT_inTable_SDTCO(String phone) {
			try {
			//	javax.persistence.Query namedQuery = entityManager.createQuery("delete NhaDat where phone = '"+phone+"'");
				javax.persistence.Query namedQuery = entityManager.createNativeQuery("delete Nha_Dat where phone = '"+phone+"'");
				int irows = namedQuery.executeUpdate();
				logger.info("=== XOA THANH CONG CAC RECORD NHA DAT CO SDT LA : " + phone + "SO DONG DA XOA LA = " + irows);
			}catch (Exception e) {
				logger.info("=== XOA KHONG THANH CONG CAC RECORD NHA DAT CO SDT LA : " + phone);
			}
			
			
		
		
	}

	public boolean findOne_where_Phone(String phone) {
		List<NhaDat> rs = null;
		TypedQuery<NhaDat> namedQuery = null;
		try {
			namedQuery = entityManager.createQuery("Select s from NhaDat s where s.phone = '" + phone + "'",
					NhaDat.class);
			rs = namedQuery.getResultList();
		} catch (NoResultException e) {
			return false;
		}
		if(rs.size() == 0 || rs == null) {
			return false;
		}else {
			return true;
		}
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNamePROPERTY_ROAD_CONDITION(
			String tinhthanhpho, String quanhuyen, String cata, String type, String road) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+
				"' and f.areaName = '" +quanhuyen+"' and f.catalogyName = '"+
				cata+"' and f.propertyRoadCondition = '" +road+ "' and f.typeName = '" +type+ "' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNamePROPERTY_ROAD_CONDITIONTuTimKiem(
			String tinhthanhpho, String quanhuyen, String cata, String type, String road, String tutimkiem) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+
				"' and f.areaName = '" +quanhuyen+"' and f.catalogyName = '"+cata+"' and f.typeName ='" 
				+type+ "' and f.propertyRoadCondition = '" +road+ "' and f.subjectLowerCase '%"+tutimkiem+ "%' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameCatalogyNameTypeNamePROPERTY_ROAD_CONDITION(
			String tinhthanhpho, String cata, String type, String road) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho+
				"' and f.catalogyName = '"+cata+"' and f.typeName ='" 
				+type+ "' and f.propertyRoadCondition = '" +road+ "' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<NhaDat> findAll_where_Top100_With_RegionNameCatalogyNameTypeName(String tinhthanhpho,
			String cata, String type) {
		TypedQuery<NhaDat> namedQuery = entityManager.createQuery("Select f from NhaDat f where f.regionName  = '"+tinhthanhpho
				+"' and f.catalogyName = '"+cata+"' and f.typeName ='" +type+ "' order by f.dateUploadConvert desc", NhaDat.class);
		namedQuery.setMaxResults(100);
		List<NhaDat> resultList = namedQuery.getResultList();
		return resultList;
		
	}

	public long count_All() {
		TypedQuery<Long> query = entityManager.createQuery(
			      "SELECT COUNT(c) FROM NhaDat c", Long.class);
		long nhadatCount = query.getSingleResult();
		return nhadatCount;
	}

	public long count_Where_RegionName(String string) {
		TypedQuery<Long> query = entityManager.createQuery(
			      "SELECT COUNT(c) FROM NhaDat c Where c.regionName ='"+ string+ "'", Long.class);
		long nhadatCount = query.getSingleResult();
		return nhadatCount;
	}

	public NhaDat findOne_where_ID(int i) {
		NhaDat result;
		TypedQuery<NhaDat> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select nd from NhaDat nd where nd.id = "+ i, NhaDat.class);
			result = namedQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return result;
	}

	


}
