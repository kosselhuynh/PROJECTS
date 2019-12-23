package com.springdatabase.basics.databasedemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.Trending;

@Repository
@Transactional
public class TrendingService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	EntityManager entityManager;

	//Get list
		public List<Trending> findAll(){
			TypedQuery<Trending> namedQuery = entityManager.createNamedQuery("find_all_trending",Trending.class);
			return namedQuery.getResultList();
		}
		
	public void insert(Trending trending) {
		entityManager.merge(trending);
		logger.info("Insert table Trending success");
	}
	
	public Trending findOne_where_Name(String name) {
		Trending result;
		TypedQuery<Trending> namedQuery;
		try {
			namedQuery = entityManager.createQuery("Select t from Trending t where t.nameSearch = '"+name+"'", Trending.class);
			result = namedQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return result;
	}

	public List<Trending> findTop10Trending() {
		TypedQuery<Trending> namedQuery = entityManager.createQuery("Select t from Trending t order by t.numberSearch desc", Trending.class);
		namedQuery.setMaxResults(10);
		List<Trending> resultList = namedQuery.getResultList();
		return resultList;
		
	}

}
