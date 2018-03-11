package com.kumar.learningspringboot.restcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
	@RequestMapping
	public String sayHelloWorld()
	{
		return "You are in new Home Page";
	}

	@GetMapping("test")
	public String handleGetRequest()
	{
		return "Get Request Handled";
	}

	@PostMapping("test")
	public String handlePostRequest()
	{
		return "Post Request Handled";
	}

	@PutMapping("test")
	public String handlePutRequest()
	{
		return "Put Request Handled";
	}

	@DeleteMapping("test")
	public String handleDeleteRequest()
	{
		return "Delete Request Handled";
	}

	@PatchMapping("test")
	public String handlePatchRequest()
	{
		return "Patch Request Handled";
	}
}