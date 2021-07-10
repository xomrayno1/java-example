package com.tampro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Employee {
	
 	@JsonProperty("employee_id")
	private String employeeId;
	private String name;
	 
	
	public Employee() {
		 
	}
	public Employee(String employeeId, String name ) {
		 
		this.employeeId = employeeId;
		this.name = name;
		 
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + "]";
	}
	 
	

}
