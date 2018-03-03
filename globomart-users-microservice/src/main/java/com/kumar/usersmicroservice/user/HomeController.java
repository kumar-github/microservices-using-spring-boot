/**
 * Copyright (c) 2018 by amphorainc.com. All rights reserved.
 * created on 26-Feb-2018
 */
package com.kumar.usersmicroservice.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saravana Kumar M
 *
 */

@RestController
public class HomeController
{
	@Value("${config: This is default value}")
	private String config;

	@RequestMapping
	public String showHomePage()
	{
		return "You are on the home page of Globo-Mart.";
	}

	@RequestMapping("/config")
	public String getConfig()
	{
		return this.config;
	}
}