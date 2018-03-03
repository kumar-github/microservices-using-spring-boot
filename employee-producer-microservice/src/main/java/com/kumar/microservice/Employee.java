package com.kumar.microservice;

public class Employee
{
	private int empId;
	private String empName;
	private double empSalary;

	public Employee()
	{
	}

	public Employee(final int empId, final String empName, final double empSalary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public int getEmpId()
	{
		return this.empId;
	}

	public void setEmpId(final int empId)
	{
		this.empId = empId;
	}

	public String getEmpName()
	{
		return this.empName;
	}

	public void setEmpName(final String empName)
	{
		this.empName = empName;
	}

	public double getEmpSalary()
	{
		return this.empSalary;
	}

	public void setEmpSalary(final double empSalary)
	{
		this.empSalary = empSalary;
	}
}