package com.tampro.command.exam02;
/*
 * Client
 */
public class Customer {
	private Waiter waiter;

	public Customer(Waiter waiter) {
		this.waiter = waiter;
	}
	
	public void request(String request) {
		Order order;
		if(request.equalsIgnoreCase("pizza")) {
			order = new Pizza();
		}else {
			order = new Steak();
		}
		waiter.takeOrder(order); //invoker call
	}
}
