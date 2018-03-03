package com.kumar.microservice;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class EmployeeConsumerApplication
{
	public static void main(final String[] args)
	{
		SpringApplication.run(EmployeeConsumerApplication.class, args);
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

	private static HttpEntity<?> getHeaders() throws IOException
	{
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}