/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kumar.usersmicroservice.user.User;
import com.kumar.usersmicroservice.user.UserRepository;

/**
 * @author Saravana Kumar M
 *
 */

@SpringBootApplication
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
		this.userRepository.save(new User(1001, "Ken", "BAD"));
		this.userRepository.save(new User(1002, "Don", "GOOD"));
		this.userRepository.save(new User(1003, "Steve", "OK"));
		this.userRepository.save(new User(1004, "Emiliano", "GOOD"));
		this.userRepository.save(new User(1005, "Kevin", "OK"));
		this.userRepository.save(new User(1006, "Jason", "BAD"));
		this.userRepository.save(new User(1007, "Anderson", "BAD"));
	}
}