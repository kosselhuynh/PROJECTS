package com.springdatabase.basics.databasedemo.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springdatabase.basics.databasedemo.controller.CountCatalogy;
import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.Trending;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

@Repository
@Transactional
public class FilesService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager entityManager;
	
	//Get list
	public List<Files> findAll(){
		TypedQuery<Files> namedQuery = entityManager.createNamedQuery("find_all_files",Files.class);
		return namedQuery.getResultList();
	}

	public List<Files> findAll_where_likeName(String likeName){
		String[] arrLikeName = likeName.split(" ");
		if(arrLikeName.length == 2) {
			List<Files> resultLists = new ArrayList<Files>();
			for (int i = 0; i < arrLikeName.length; i++) {
				TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+arrLikeName[0]+"%' and f.name like '%"+arrLikeName[1]+"%' order by  f.downloads, f.dateUpload desc", Files.class);
				List<Files> resultList = namedQuery.getResultList();
				resultLists.addAll(resultList);
			}
			return resultLists;
		}else if(arrLikeName.length == 3) {
			List<Files> resultLists = new ArrayList<Files>();
			for (int i = 0; i < arrLikeName.length; i++) {
				TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+arrLikeName[0]+"%' and f.name like '%"+arrLikeName[1]+"%' and f.name like '%"+arrLikeName[2]+"%' order by  f.downloads, f.dateUpload desc", Files.class);
				List<Files> resultList = namedQuery.getResultList();
				resultLists.addAll(resultList);
			}
			return resultLists;
		}else if(arrLikeName.length > 3) {
			List<Files> resultLists = new ArrayList<Files>();
			for (int i = 0; i < arrLikeName.length; i++) {
				TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+arrLikeName[i]+ "%' order by  f.downloads, f.dateUpload desc", Files.class);
				List<Files> resultList = namedQuery.getResultList();
				resultLists.addAll(resultList);
			}
			return resultLists;
		}else {
			TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+likeName+"%' order by  f.downloads, f.dateUpload desc", Files.class);
			List<Files> resultLists = namedQuery.getResultList();
			return resultLists;
		}
		
	}
	
	public List<Files> findAll_where_likeNameAndInCatalogy(String likeName, String catalogy){
		String[] arrLikeName = likeName.split(" ");
		if(arrLikeName.length == 2) {
			List<Files> resultLists = new ArrayList<Files>();
			for (int i = 0; i < arrLikeName.length; i++) {
				TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+arrLikeName[0]+"%' and f.name like '%"+arrLikeName[1]+"%' and f.catalogy = '" +catalogy+"'", Files.class);
				List<Files> resultList = namedQuery.getResultList();
				resultLists.addAll(resultList);
			}
			return resultLists;
		}else if(arrLikeName.length == 3) {
			List<Files> resultLists = new ArrayList<Files>();
			for (int i = 0; i < arrLikeName.length; i++) {
				TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+arrLikeName[0]+"%' and f.name like '%"+arrLikeName[1]+"%' and f.name like '%"+arrLikeName[2]+"%' and f.catalogy = '" +catalogy+"'", Files.class);
				List<Files> resultList = namedQuery.getResultList();
				resultLists.addAll(resultList);
			}
			return resultLists;
		}else if(arrLikeName.length > 3) {
			List<Files> resultLists = new ArrayList<Files>();
			for (int i = 0; i < arrLikeName.length; i++) {
				TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+arrLikeName[i]+"%' and f.catalogy = '" +catalogy+"'", Files.class);
				List<Files> resultList = namedQuery.getResultList();
				resultLists.addAll(resultList);
			}
			return resultLists;
		}else {
			TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.name like '%"+likeName+"%' and f.catalogy = '" +catalogy+"'", Files.class);
			List<Files> resultLists = namedQuery.getResultList();
			return resultLists;
		}
		
	}
	

	public Files findById(int id) {
		return entityManager.find(Files.class, id);
	}
	
	public void insert(List<Files> listFiles) {
		for (Files files : listFiles) {
			entityManager.merge(files);
		}

	}
	public void insert(Files file) {
			entityManager.merge(file);
	}
	
	public List<Files> findAll_where_Top100() {
		TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f order by f.downloads desc", Files.class);
		namedQuery.setMaxResults(100);
		List<Files> resultList = namedQuery.getResultList();
		return resultList;
	}

	public boolean findAll_isExist_Where_sameNameAndSize(String nameNew, String sizeNew) {
		// Return True : is Exist in DB
		// Return False : is not Exist in DB
		List<Files> listResult;
		TypedQuery<Files> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select f from Files f where f.name = '"+nameNew+"' and f.size = '"+sizeNew+ "'", Files.class);
			listResult = namedQuery.getResultList();
			if(listResult.size() > 0) {
				return true;
			}else {
				return false;
			}
		}catch (NoResultException e) {
			return false;
		}

	}

	public List<Files> findAll_where_Top10() {
		TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f order by f.downloads desc", Files.class);
		namedQuery.setMaxResults(10);
		List<Files> resultList = namedQuery.getResultList();
		return resultList;
	}

	public List<Files> findAll_where_Catalogy(String catalogy) {
		TypedQuery<Files> namedQuery = entityManager.createQuery("Select f from Files f where f.catalogy = '" +catalogy+"'", Files.class);
		List<Files> resultList = namedQuery.getResultList();
		return resultList;
	}

	/*public List<CountCatalogy> findAll_CountCatalogy() {
		
		  List<CountCatalogy> listCountCatalogy = new ArrayList<CountCatalogy>();
		  TypedQuery<Files> namedQuery = entityManager.
		  createQuery("Select count(f.catalogy) as f.size, f.catalogy from Files f GROUP BY f.catalogy"
		  , Files.class); List<Files> resultList = namedQuery.getResultList();
		  for(Files file : resultList) { System.out.println("Catalogy : " +
		  file.getCatalogy()); System.out.println("Count = " + file.getSize()); }
		  return listCountCatalogy;
		 
	}*/
	
}
