package com.springdatabase.basics.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableScheduling
public class DatabaseDemoApplication extends SpringBootServletInitializer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
		
	}
	

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
//			ChoTot chotot = restTemplate.getForObject(
//					"https://gateway.chotot.com/v1/public/ad-listing?region_v2=13000&cg=1000&limit=30", ChoTot.class);
//			logger.info(chotot.toString());
		};
	}
	
	@Bean
	  public TaskScheduler taskScheduler() {
	    final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
	    scheduler.setPoolSize(10);
	    return scheduler;
	}
	

}
