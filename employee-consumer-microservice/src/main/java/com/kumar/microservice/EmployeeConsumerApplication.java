package com.kumar.microservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@EnableEurekaClient
@EnableDiscoveryClient
public class EmployeeConsumerApplication
{
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public static void main(final String[] args)
	{
		SpringApplication.run(EmployeeConsumerApplication.class, args);
	}

	@RequestMapping("/home")
	public String showHomePage()
	{
		return "<html><head></head><body bgcolor=\'#a2ab58\'><h1>Welcome to Employee Consumer!</h1></body></html>";
	}

	@RequestMapping("/employees")
	public ResponseEntity<String> getEmployees() //throws RestClientException, IOException
	{
		final String baseUrl = "http://localhost:8001/employees";
		final RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try
		{
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		}
		catch(final Exception ex)
		{
			System.out.println(ex);
		}
		return response;
	}

	@RequestMapping("/employees2")
	public ResponseEntity<String> getEmployeesThroughEurekaServer()
	{
		final ServiceInstance serviceInstance = this.discoveryClient.getInstances("employee-producer-microservice").get(0);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/employees";
		final RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try
		{
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		}
		catch(final Exception ex)
		{
			System.out.println(ex);
		}
		return response;
	}

	@RequestMapping("/employees3")
	public ResponseEntity<String> getEmployeesThroughLoadBalancer()
	{
		final ServiceInstance serviceInstance = this.loadBalancerClient.choose("employee-producer-microservice");
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/employees";
		final RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try
		{
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		}
		catch(final Exception ex)
		{
			System.out.println(ex);
		}
		return response;
	}

	private static HttpEntity<?> getHeaders() throws IOException
	{
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}