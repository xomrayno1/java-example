package com.tampro.command.exam02;
/*
 * ConCreate Command
 */

/*
 * Các case cần xử lý
 * 
 * Receiver sẽ xử lý case này , trường hợp này là PizzaChef
 */
public class Pizza implements Order{
	
	private PizzaChef pizzaChef;

	public Pizza( ) {
		this.pizzaChef = new PizzaChef();
	}

	public PizzaChef getPizzaChef() {
		return pizzaChef;
	}

	public void setPizzaChef(PizzaChef pizzaChef) {
		this.pizzaChef = pizzaChef;
	}

	@Override
	public String toString() {
		return "Pizza";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		pizzaChef.makeSteak();
	}

}
