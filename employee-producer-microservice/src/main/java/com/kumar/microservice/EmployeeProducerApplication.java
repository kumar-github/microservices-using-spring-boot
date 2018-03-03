package com.kumar.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class EmployeeProducerApplication
{
	public static void main(final String[] args)
	{
		SpringApplication.run(EmployeeProducerApplication.class, args);
	}
}