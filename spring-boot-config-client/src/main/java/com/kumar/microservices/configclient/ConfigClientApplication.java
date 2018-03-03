package com.kumar.microservices.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@RefreshScope
public class ConfigClientApplication
{
	@Value("${keyfromdevelopment: This is default value}")
	//@Value("${keyfromdefault: This is default value}")
	private String message;

	public static void main(final String[] args)
	{
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RequestMapping("/config")
	public String getConfig()
	{
		return this.message;
	}
}