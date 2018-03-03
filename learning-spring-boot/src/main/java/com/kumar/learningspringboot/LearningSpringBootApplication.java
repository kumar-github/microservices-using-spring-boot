package com.kumar.learningspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@EnableConfigServer
public class LearningSpringBootApplication
{
	@Autowired
	private PersonRepository personRepository;

	public static void main(String... args)
	{
		System.out.println("Inside main method");
		SpringApplication.run(LearningSpringBootApplication.class, args);
		System.out.println("Completed main method");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext)
	{
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot");

			/*final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
			Arrays.sort(beanDefinitionNames);
			for(String beanDefinitionName : beanDefinitionNames)
			{
				System.out.println(beanDefinitionName);
			}
			personRepository.save(new Person("Ken", 50, "Houston"));
			personRepository.save(new Person("Don", 45, "Houston"));
			personRepository.save(new Person("Davinder", 50, "Hyderabad"));
			personRepository.save(new Person("Kashyap", 40, "Hyderabad"));
			personRepository.save(new Person("Veeru", 38, "Hyderabad"));
			System.out.println("New persons saved.");*/
		};
	}

	@PostConstruct
	private void doInit()
	{
		personRepository.save(new Person("Ken", 50, "Houston"));
		personRepository.save(new Person("Don", 45, "Houston"));
		personRepository.save(new Person("Davinder", 50, "Hyderabad"));
		personRepository.save(new Person("Kashyap", 40, "Hyderabad"));
		System.out.println("New persons saved.");
	}
}