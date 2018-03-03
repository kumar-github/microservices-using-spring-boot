package com.kumar.learningspringboot.restcontroller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
	//@Autowired
	//private PersonRepository personRepository;

	@org.springframework.web.bind.annotation.RequestMapping
	public String sayHelloWorld()
	{
		return "You are in new Home Page";
	}

/*
	@org.springframework.web.bind.annotation.RequestMapping("/persons/{name}")
	public Person someMethod(@PathVariable String name)
	{
		return personRepository.findByName(name);
	}*/
}