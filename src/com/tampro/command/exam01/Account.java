package com.tampro.command.exam01;
/*
 * Receiver
 * 
 * Xử lý các case business logic
 */
public class Account {
	private String name;
	
	public Account(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void open() {
		System.out.println("Open account  ["+ name +"]");
	}
	
	public void close() {
		System.out.println("Close account  ["+ name +"]");
	}
	
}
