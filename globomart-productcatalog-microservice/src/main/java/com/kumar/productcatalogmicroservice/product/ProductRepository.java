/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Saravana Kumar M
 *
 */

public interface ProductRepository extends CrudRepository<Product, Integer>
{
	public Product findByProductName(final String productName);
	public List<Product> findByProductNameContaining(final String productName);
	public List<Product> findByProductType(final String productType);
	public List<Product> findByProductNameOrProductType(final String productName, final String productType);
	public List<Product> findByProductNameOrProductTypeContaining(final String productName, final String productType);
	public List<Product> findByProductNameContainingOrProductTypeContaining(final String productName, final String productType);
}