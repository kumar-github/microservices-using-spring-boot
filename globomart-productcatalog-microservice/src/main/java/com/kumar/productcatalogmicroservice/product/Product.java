/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice.product;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Saravana Kumar M
 *
 */

@Entity
public class Product
{
	@Id
	private Integer productId;
	private String productName;
	private String productDescription;
	private String productType;

	public Product()
	{
	}

	public Product(final int productId, final String productName, final String productDescription, final String productType)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productType = productType;
	}

	public int getProductId()
	{
		return this.productId;
	}

	public void setProductId(final int productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return this.productName;
	}

	public void setProductName(final String productName)
	{
		this.productName = productName;
	}

	public String getProductDescription()
	{
		return this.productDescription;
	}

	public void setProductDescription(final String productDescription)
	{
		this.productDescription = productDescription;
	}

	public String getProductType()
	{
		return this.productType;
	}

	public void setProductType(final String productType)
	{
		this.productType = productType;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.productId == null) ? 0 : this.productId.hashCode());
		result = (prime * result) + ((this.productName == null) ? 0 : this.productName.hashCode());
		result = (prime * result) + ((this.productDescription == null) ? 0 : this.productDescription.hashCode());
		result = (prime * result) + ((this.productType == null) ? 0 : this.productType.hashCode());
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
		final Product other = (Product) obj;
		if(this.productDescription == null)
		{
			if(other.productDescription != null)
				return false;
		}
		else if(!this.productDescription.equals(other.productDescription))
			return false;
		if(this.productId == null)
		{
			if(other.productId != null)
				return false;
		}
		else if(!this.productId.equals(other.productId))
			return false;
		if(this.productName == null)
		{
			if(other.productName != null)
				return false;
		}
		else if(!this.productName.equals(other.productName))
			return false;
		if(this.productType == null)
		{
			if(other.productType != null)
				return false;
		}
		else if(!this.productType.equals(other.productType))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Product [productId=" + this.productId + ", productName=" + this.productName + ", productDescription=" + this.productDescription + ", productType=" + this.productType + "]";
	}
}