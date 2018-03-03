/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice.product;

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
public class ProductController
{
	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public List<Product> getAllProducts()
	{
		return this.productService.getAllProducts();
	}

	//@RequestMapping("/products/{productId}")
	@RequestMapping("/products/{productId:[0-9]+}")
	public Product getProductById(@PathVariable final int productId)
	{
		return this.productService.getProductById(productId);
	}

	/*
	//@RequestMapping("/products/{productName}")
	@RequestMapping("/products/{productName:[a-zA-Z]+}")
	public List<Product> getProductByName(@PathVariable final String productName)
	{
		return this.productService.getProductByName(productName);
	}

	@RequestMapping("/products/{productType:[a-zA-Z]+}")
	public List<Product> getProductsByType(@PathVariable final String productType)
	{
		return this.productService.getProductsByType(productType);
	}
	*/

	// Commented the above 2 methods and implemented the below one. This method is capable of doing both the method's stuff.
	@RequestMapping("/products/{productNameOrProductType:[a-zA-Z]+}")
	//public Product getProductByName(@PathVariable final String productName)
	public List<Product> getProductByNameOrType(@PathVariable final String productNameOrProductType)
	{
		//return this.productService.getProductByName(productName);
		return this.productService.getProductByNameOrType(productNameOrProductType);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody final Product aProduct)
	{
		this.productService.saveProduct(aProduct);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}")
	public void updateProduct(@PathVariable final int productId, @RequestBody final Product aProduct)
	{
		this.productService.saveProduct(aProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}")
	public void deleteProduct(@PathVariable final int productId)
	{
		this.productService.deleteProduct(productId);
	}
}