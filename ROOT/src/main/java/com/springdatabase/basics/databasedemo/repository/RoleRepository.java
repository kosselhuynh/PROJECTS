package com.springdatabase.basics.databasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdatabase.basics.databasedemo.entity.Role;



public interface RoleRepository extends CrudRepository<Role, Integer>{

}
