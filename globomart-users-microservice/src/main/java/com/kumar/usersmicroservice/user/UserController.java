/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saravana Kumar M
 *
 */

@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers()
	{
		return this.userService.getAllUsers();
	}

	@RequestMapping("/users/{userId:[0-9]+}")
	public User getUserById(@PathVariable final int userId)
	{
		return this.userService.getUserById(userId);
	}

	@RequestMapping("/users/{userRating:[a-zA-Z]+}")
	public List<User> getUsersByRating(@PathVariable final String userRating)
	{
		return this.userService.getUsersByRating(userRating);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody final User aUser)
	{
		this.userService.saveUser(aUser);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	public void updateUser(@PathVariable final int userId, @RequestBody final User aUser)
	{
		this.userService.saveUser(aUser);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	public void deleteUser(@PathVariable final int userId)
	{
		this.userService.deleteUser(userId);
	}

	@RequestMapping("/product/{productId:[0-9]+}")
	public List<User> getUsersForProductId(@PathVariable final int productId)
	{
		return this.userService.getUsersByProductId(productId);
	}
}