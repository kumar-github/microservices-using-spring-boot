package com.kumar.learningspringboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person
{
	@Id
	@GeneratedValue
	Integer id;

	private String name;
	private int age;
	private String address;

	public Person()
	{
	}

	public Person(final String name, final int age, final String address)
	{
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(final int age)
	{
		this.age = age;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(final String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Person{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
	}
}