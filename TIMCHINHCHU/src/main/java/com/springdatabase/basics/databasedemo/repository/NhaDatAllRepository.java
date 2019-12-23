package com.springdatabase.basics.databasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatabase.basics.databasedemo.entity.NhaDatAll;

public interface NhaDatAllRepository  extends CrudRepository<NhaDatAll, Integer> {

}
