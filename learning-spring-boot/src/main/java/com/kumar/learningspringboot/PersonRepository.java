package com.kumar.learningspringboot;

import org.springframework.data.repository.CrudRepository;

//@RestResource(path = "persons", rel = "persons")
public interface PersonRepository extends CrudRepository<Person, Integer>
{
	/*
	@Override
	Iterable<Person> findAll();

	@Override
	Iterable<Person> findAll(Iterable<Integer> integers);

	@Override
	Person findOne(Integer integer);

	Person findByName(String name);*/
}