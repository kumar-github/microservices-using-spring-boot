package com.kumar.learningspringboot;

import org.springframework.boot.CommandLineRunner;

//@Component
public class HelloCommandLineRunner implements CommandLineRunner
{
	@Override
	public void run(final String... args) throws Exception
	{
		System.out.println("This is to test Command Line Runner...");
	}
}