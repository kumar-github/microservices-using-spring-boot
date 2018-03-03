/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice.user;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Saravana Kumar M
 *
 */

@Entity
public class User
{
	@Id
	private Integer userId;
	private String userName;
	private String userRating;

	public User()
	{
	}

	public User(final int userId, final String userName, final String userRating)
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRating = userRating;
	}

	public int getUserId()
	{
		return this.userId;
	}

	public void setUserId(final int productId)
	{
		this.userId = productId;
	}

	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(final String productName)
	{
		this.userName = productName;
	}

	public String getUserRating()
	{
		return this.userRating;
	}

	public void setUserRating(final String userRating)
	{
		this.userRating = userRating;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.userId == null) ? 0 : this.userId.hashCode());
		result = (prime * result) + ((this.userName == null) ? 0 : this.userName.hashCode());
		result = (prime * result) + ((this.userRating == null) ? 0 : this.userRating.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if(this.userRating == null)
		{
			if(other.userRating != null)
				return false;
		}
		else if(!this.userRating.equals(other.userRating))
			return false;
		if(this.userId == null)
		{
			if(other.userId != null)
				return false;
		}
		else if(!this.userId.equals(other.userId))
			return false;
		if(this.userName == null)
		{
			if(other.userName != null)
				return false;
		}
		else if(!this.userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + this.userId + ", userName=" + this.userName + ", userRating=" + this.userRating + "]";
	}
}