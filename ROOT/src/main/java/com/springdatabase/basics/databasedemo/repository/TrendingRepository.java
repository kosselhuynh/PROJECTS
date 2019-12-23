package com.springdatabase.basics.databasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatabase.basics.databasedemo.entity.Files;

public interface TrendingRepository extends CrudRepository<Files, Integer> {

}
