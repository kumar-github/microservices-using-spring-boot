package com.kumar.productcatalogmicroservice;
/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on Mar 5, 2018
 */

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Saravana Kumar M
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductCatalogMicroserviceApplicationTests
{
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() throws Exception
	{
	}

	@Test
	public void sampleTest()
	{
		//assertThat(this.restTemplate.getForObject("http://localhost:56524/home", String.class)).contains("You are on the home page of Globo-Mart.");
	}
}