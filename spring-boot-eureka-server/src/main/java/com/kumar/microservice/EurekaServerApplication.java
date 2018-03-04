package com.kumar.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class EurekaServerApplication
{
	public static void main(final String[] args)
	{
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#a2ab58\'><h1>Welcome to Spring Cloud Eureka Server!</h1></body></html>";
	}
}