package com.springdatabase.basics.databasedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springdatabase.basics.databasedemo.controller.CountCatalogy;
import com.springdatabase.basics.databasedemo.entity.Files;

public interface FilesRepository extends CrudRepository<Files, Integer>{

	@Query("Select count(f.catalogy) as count, f.catalogy as catalogy from Files f GROUP BY f.catalogy")
	List<CountCatalogy> findCatalogyCount();
}
