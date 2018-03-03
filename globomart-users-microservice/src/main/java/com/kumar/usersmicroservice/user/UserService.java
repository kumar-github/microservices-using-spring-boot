/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Saravana Kumar M
 *
 */

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers()
	{
		//return StreamSupport.stream(this.productRepository.findAll().spliterator(), false).collect(Collectors.toList());

		final List<User> allUsers = new ArrayList<>();
		this.userRepository.findAll().forEach(allUsers::add);
		return allUsers;
	}

	public User getUserById(final int userId)
	{
		//return this.getAllUsers().stream().filter(aUser -> (aUser.getUserId() == productId)).findFirst().get();
		return this.userRepository.findOne(userId);
	}

	public List<User> getUsersByRating(final String userRating)
	{
		//return this.getAllUsers().stream().filter(aUser -> aUser.getUserName().equals(productName)).findFirst().get();
		return this.userRepository.findByUserRating(userRating);
	}

	public void saveUser(final User aUser)
	{
		this.userRepository.save(aUser);
	}

	public void updateUser(final User aUSer)
	{
		this.userRepository.save(aUSer);
	}

	public void deleteUser(final int userId)
	{
		this.userRepository.delete(userId);
	}
}