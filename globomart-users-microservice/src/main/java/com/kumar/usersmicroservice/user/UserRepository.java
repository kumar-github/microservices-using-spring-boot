/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Saravana Kumar M
 *
 */

public interface UserRepository extends CrudRepository<User, Integer>
{
	public List<User> findByUserRating(final String userRating);
}