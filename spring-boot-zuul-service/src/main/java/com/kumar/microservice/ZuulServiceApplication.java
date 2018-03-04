package com.kumar.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@RestController
public class ZuulServiceApplication
{
	public static void main(final String[] args)
	{
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#a2ab58\'><h1>You are on the home page of Zuul Gateway!</h1></body></html>";
	}
}