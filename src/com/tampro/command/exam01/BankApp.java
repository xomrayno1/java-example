package com.tampro.command.exam01;

/*
 *   Invoker : tiếp nhận ConcreteCommand từ Client và gọi execute() của ConcreteCommand để thực thi request.
 */

 
public class BankApp {
	private Command openAccount;
	private Command closeAccount;
	
	public BankApp(Command openAccount, Command closeAccount) {
		this.openAccount = openAccount;
		this.closeAccount = closeAccount;
	}

	public Command getOpenAccount() {
		return openAccount;
	}

	public void setOpenAccount(Command openAccount) {
		this.openAccount = openAccount;
	}

	public Command getCloseAccount() {
		return closeAccount;
	}

	public void setCloseAccount(Command closeAccount) {
		this.closeAccount = closeAccount;
	}

	public void clickOpenAccount() {
		System.out.println("User click open an account");
		openAccount.execute();
	}
	
	public void clickCloseAccount() {
		System.out.println("User click close an account");
		closeAccount.execute();
	}
}
