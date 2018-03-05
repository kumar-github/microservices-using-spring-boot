/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.kumar.usersmicroservice.user.User;
import com.kumar.usersmicroservice.user.UserRepository;

/**
 * @author Saravana Kumar M
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class UsersMicroserviceApplication
{
	@Autowired
	private UserRepository userRepository;

	public static void main(final String... args)
	{
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}

	//@PostConstruct
	public void setupInitialData()
	{
		this.userRepository.save(new User(1001, "Ken", "BAD", 101));
		this.userRepository.save(new User(1002, "Don", "GOOD", 101));
		this.userRepository.save(new User(1003, "Steve", "OK", 201));
		this.userRepository.save(new User(1004, "Emiliano", "GOOD", 201));
		this.userRepository.save(new User(1005, "Kevin", "OK", 301));
		this.userRepository.save(new User(1006, "Jason", "BAD", 302));
		this.userRepository.save(new User(1007, "Anderson", "BAD", 302));
	}
}