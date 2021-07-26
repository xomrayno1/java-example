package com.tampro.command.exam02;
/*
 * ConCreate Command
 */

/*
 * Các case cần xử lý
 * 
 * Receiver sẽ xử lý case này , trường hợp này là SteakChef
 */
public class Steak implements Order{
	
	private SteakChef steakChef;

	public Steak() {
		this.steakChef = new SteakChef();
	}

	public SteakChef getSteakChef() {
		return steakChef;
	}
	
	public void setSteakChef(SteakChef steakChef) {
		this.steakChef = steakChef;
	}

	@Override
	public String toString() {
		return "Steak";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		steakChef.makeSteak();
	}

}
