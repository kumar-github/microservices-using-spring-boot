/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Saravana Kumar M
 *
 */

@Service
public class ProductService
{
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts()
	{
		//return StreamSupport.stream(this.productRepository.findAll().spliterator(), false).collect(Collectors.toList());

		final List<Product> allProducts = new ArrayList<>();
		this.productRepository.findAll().forEach(allProducts::add);
		return allProducts;
	}

	public Product getProductById(final int productId)
	{
		return this.productRepository.findOne(productId);
	}

	public List<Product> getProductByName(final String productName)
	{
		//return this.productRepository.findByProductName(productName);
		return this.productRepository.findByProductNameContaining(productName);
	}

	public List<Product> getProductByNameOrType(final String productNameOrProductType)
	{
		//return this.productRepository.findByProductNameContaining(productNameOrProductType);
		//return this.productRepository.findByProductNameOrProductTypeContaining(productNameOrProductType);
		//return this.productRepository.findByProductNameOrProductType(productNameOrProductType, productNameOrProductType);
		//return this.productRepository.findByProductNameOrProductTypeContaining(productNameOrProductType, productNameOrProductType);
		return this.productRepository.findByProductNameContainingOrProductTypeContaining(productNameOrProductType, productNameOrProductType);
	}

	public List<Product> getProductsByType(final String productType)
	{
		return this.productRepository.findByProductType(productType);
	}

	public void saveProduct(final Product aProduct)
	{
		this.productRepository.save(aProduct);
	}

	public void updateProduct(final Product aProduct)
	{
		this.productRepository.save(aProduct);
	}

	public void deleteProduct(final int productId)
	{
		this.productRepository.delete(productId);
	}
}