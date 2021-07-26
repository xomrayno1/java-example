package com.tampro.command.exam01;
/*
 * ConcreteCommand: là các implementation của Command. 
 * 					Định nghĩa một sự gắn kết giữa một đối tượng Receiver và một hành động. 
 * 					Thực thi execute() bằng việc gọi đang hoãn trên Receiver. 
 * 					Mỗi một ConcreteCommand sẽ phục vụ cho một case request riêng.
 * 
 */

/*
 * Mỗi một ConcreteCommand sẽ phục vụ cho một case request riêng.
 * 
 * Các case cần xử lý
 */
public class OpenAccount implements Command{
	private Account account;

	public OpenAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.open();
	}

}
