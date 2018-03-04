package com.kumar.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication
{
	@Autowired
	//private EurekaClient eurekaClient;
	private DiscoveryClient discoveryClient;

	public static void main(final String[] args)
	{
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#ff5e62\'><h1>Welcome to Spring Cloud Eureka Client!</h1></body></html>";
	}

	@RequestMapping("/greeting")
	public String greeting()
	{
		return "Hello from EurekaClient!";
	}

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> getServiceInstancesByApplicationName(@PathVariable final String applicationName)
	{
		//return this.eurekaClient.getInstancesById(applicationName);
		//final InstanceInfo nextServerFromEureka = this.eurekaClient.getNextServerFromEureka("STORES", false);
		//System.out.println(nextServerFromEureka.getHomePageUrl());
		return this.discoveryClient.getInstances(applicationName);
	}
}