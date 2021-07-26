package com.tampro.command.exam01;
/*
 * ConcreteCommand
 */

/*
 * Các case cần xử lý
 */
public class CloseAccount implements Command{
	private Account account;

	public CloseAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	// call method từ receiver
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.close();
	}

}
