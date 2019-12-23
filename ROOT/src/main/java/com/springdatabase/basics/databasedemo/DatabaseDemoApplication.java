package com.springdatabase.basics.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
//@RestController
public class DatabaseDemoApplication extends SpringBootServletInitializer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Autowired
//	PersonJpaRepository repository;
//	
//	@Autowired
//	PersonRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
		
	}
	
//	@RequestMapping(value = "/")
//	   public String hello() {
//	      return "files";
//	   }


	
//	@Override
//	public void run(String...args) throws Exception{
//		logger.info("Find user by Id -> {} ", repository.findById(10001));
//		
//		logger.info("Insert users 10004-> {} ", repository.insert(new Person(10004, "Tara", "Berlin", new Date())));
//		
//		logger.info("Update users 10003-> {} ", repository.update(new Person(10003, "Peter", "Bankog", new Date())));
//		
//		repository.deleteById(10002);
//		
//		logger.info("All users -> {}", repository.findAll());
//		
//		logger.info("User Repo -- select user : {} ", repo.findById(10003));
//	}
	
//	@RequestMapping(value = "/")
//	   public String hello() {
//	      return "Hello World";
//	   }
}
