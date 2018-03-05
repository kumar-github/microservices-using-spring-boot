/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice.product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Saravana Kumar M
 *
 */

@RestController
public class ProductController
{
	@Autowired
	private ProductService productService;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

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

	@RequestMapping("/products/{productId:[0-9]+}/users")
	public List<User> getUsersForProductId(@PathVariable final int productId)
	{
		final ServiceInstance serviceInstance = this.loadBalancerClient.choose("globomart-users-microservice");
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/users";
		final RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<List<User>> response = null;
		try
		{
			//response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			final User[] allUsers = restTemplate.getForObject(baseUrl, User[].class);
			return Arrays.asList(allUsers).stream().filter(anUser -> anUser.getProductId() == productId).collect(Collectors.toList());
		}
		catch(final Exception ex)
		{
			System.out.println(ex);
		}
		//return response;
		return null;
	}

	private static HttpEntity<?> getHeaders() throws IOException
	{
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}