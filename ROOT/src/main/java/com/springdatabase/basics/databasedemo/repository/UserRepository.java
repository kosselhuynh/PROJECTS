package com.springdatabase.basics.databasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatabase.basics.databasedemo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
