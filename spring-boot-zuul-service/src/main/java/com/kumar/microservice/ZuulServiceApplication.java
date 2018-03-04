package com.kumar.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServiceApplication
{
	@Autowired
	//private EurekaClient eurekaClient;
	private DiscoveryClient discoveryClient;

	public static void main(final String[] args)
	{
		SpringApplication.run(ZuulServiceApplication.class, args);
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