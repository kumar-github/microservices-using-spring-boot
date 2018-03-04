package com.kumar.microservices.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@RefreshScope
@EnableEurekaClient
public class ConfigClientApplication
{
	@Value("${keyfromdevelopment: This is default value}")
	//@Value("${keyfromdefault: This is default value}")
	private String message;

	public static void main(final String[] args)
	{
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#ff5e62\'><h1>Welcome to Spring Cloud Config Client!</h1></body></html>";
	}

	@RequestMapping("/config")
	public String getConfig()
	{
		return this.message;
	}
}