/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.productcatalogmicroservice.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saravana Kumar M
 *
 */

@RestController
public class HomeController
{
	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#a2ab58\'><h1>You are on the home page of Globo-Mart Product Catalog!</h1></body></html>";
	}
}