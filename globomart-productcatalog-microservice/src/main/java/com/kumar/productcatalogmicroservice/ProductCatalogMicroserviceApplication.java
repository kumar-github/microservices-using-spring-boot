/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.kumar.productcatalogmicroservice.product.Product;
import com.kumar.productcatalogmicroservice.product.ProductRepository;

/**
 * @author Saravana Kumar M
 *
 */

@SpringBootApplication
@EnableEurekaClient
//@ComponentScan(basePackages = {"com.kumar.productcatalogmicroservice", "com.kumar.productcatalogmicroservice"})
public class ProductCatalogMicroserviceApplication
{
	@Autowired
	private ProductRepository productRepository;

	public static void main(final String... args)
	{
		SpringApplication.run(ProductCatalogMicroserviceApplication.class, args);
	}

	// This will be called once the context is initialized.
	@PostConstruct
	public void setupInitialData()
	{
		this.productRepository.save(new Product(101, "Redmi 4", "Xiaomi Redmi 4 (Black, 32 GB)", "Mobile"));
		this.productRepository.save(new Product(102, "Redmi 5A", "Xiaomi Redmi 5A (White, 16 GB)", "Mobile"));
		this.productRepository.save(new Product(103, "Redmi Note 4", "Xiaomi Redmi Note 4 (Dark Grey, 64GB)", "Mobile"));

		this.productRepository.save(new Product(201, "Woodland", "Woodland Mens Leather Sneakers", "Shoe"));
		this.productRepository.save(new Product(202, "Puma", "Puma Mens Sneakers", "Shoe"));
		this.productRepository.save(new Product(203, "Fila", "Fila Mens Hunk Sneakers", "Shoe"));

		this.productRepository.save(new Product(301, "Flags", "Flags Mens Casual Denim Shirt Dark Blue", "Dress"));
		this.productRepository.save(new Product(302, "Colt", "Colt Mens Casual Shirt", "Dress"));
		this.productRepository.save(new Product(303, "SWISSCOTT", "SWISSCOTT Mens Cotton Shirt", "Dress"));
	}
}