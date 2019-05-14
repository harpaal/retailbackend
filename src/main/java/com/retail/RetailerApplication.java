package com.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Harpal Singh
 * <p>This is an api for retail applications, it has the following features:- 
 * <ul>
 * 		<li> feature to get ShopDetails with different crud operations
 * 		<li> security feature to validate if user is valid user
 * 		<li> open for future enhancements 
 * </ul>
 * 
 *
 */
@SpringBootApplication
@Slf4j
public class RetailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerApplication.class, args);
		log.info("Welcome to Retail Application");
	}

}
