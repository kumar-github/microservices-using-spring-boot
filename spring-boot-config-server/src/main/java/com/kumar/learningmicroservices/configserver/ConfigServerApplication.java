package com.kumar.learningmicroservices.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RestController
public class ConfigServerApplication
{
	public static void main(final String... args)
	{
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#ff5e62\'><h1>Welcome to Spring Cloud Config Server!</h1></body></html>";
	}
}